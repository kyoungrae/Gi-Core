/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonService;
import com.gicore.common.common.usergroup.CommonUserGroup;
import com.gicore.common.common.usergroup.CommonUserGroupMapper;
import com.gicore.common.common.mail.Mail;
import com.gicore.common.common.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SiteScheduledMailService extends AbstractCommonService<SiteScheduledMail> {
    private final SiteScheduledMailMapper siteScheduledMailMapper;
    private final CommonUserGroupMapper commonUserGroupMapper;
    private final MailService mailService;
    private final SiteScheduledMailRepository siteScheduledMailRepository;
    private final SiteSentMailManagementMapper siteSentMailManagementMapper;
    private final SiteScheduledMailTargetGroupMapper siteScheduledMailTargetGroupMapper;
    private final MessageSource messageSource;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Map<String, ScheduledFuture<?>> scheduledTasks = new HashMap<>(); //예약중인 스케쥴을 보관(mail_id로 추적)

    @Value("${spring.mail.username}")  // application.properties에 설정한 값으로 주입
    private String senderEmail;


    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SiteScheduledMail> selectPage(SiteScheduledMail request) throws Exception {
        return siteScheduledMailMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SiteScheduledMail request) throws Exception {
        return siteScheduledMailMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }

    @Override
    protected List<SiteScheduledMail> findImpl(SiteScheduledMail request) throws Exception {
        return siteScheduledMailMapper.SELECT(request);
    }

    @Transactional
    @Override
    protected int removeImpl(SiteScheduledMail request) {
        try{
            siteScheduledMailMapper.DELETE(request);
            cancelScheduledMail(request.getMail_id());
            return 1;
        } catch (Exception e){
            throw new RuntimeException("Fail delete Scheduled mail");
        }
    }

    @Override
    protected int updateImpl(SiteScheduledMail request) {
        return siteScheduledMailMapper.UPDATE(request);
    }


    //todo 로직 정리할 것
    @Transactional
    @Override
    protected int registerImpl(SiteScheduledMail request) throws Exception {
        int result = 0;
        String scheduledDate = request.getScheduled_ymd().replace("-", "");  // ex)20250222
        String scheduledTime = request.getScheduled_time();  // ex)2230

        // Mail 객체 생성
        Mail testMail = Mail.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .uuid(request.getUuid())
                .build();

        // 예약 메일 -> Date타입으로 예약일시 셋팅
        if (Objects.equals(request.getScheduled_yn(), "1")) {
            String dateTimeStr = scheduledDate + scheduledTime;  // 202502222230
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");

            try {
                Date scheduledDateTime = dateFormat.parse(dateTimeStr);
                testMail.setScheduled_date(scheduledDateTime);
                System.out.println("scheduledDateTime = " + scheduledDateTime);
            } catch (ParseException e) {
                throw new RuntimeException("Invalid scheduled time format", e);
            }
            request.setState_code("2");  // 예약 대기(2)
        }

        // 1. Mail insert
        try {
            if (!Objects.equals(request.getState_code(), "2")) request.setState_code("3"); //예약이 아니라면 대기중(3)
            siteScheduledMailMapper.INSERT_AND_RETURN_ID(request);
        } catch (Exception e) {
            System.out.println("siteScheduledMailMapper - INSERT_AND_RETURN_ID fail" + e.getMessage());
            throw new RuntimeException("Failed to insert mail into database", e);
        }

        String mail_id = request.getMail_id();
        testMail.setMail_id(mail_id);

        // 2. 메일 전송(예약)
        try {
            // 발송 진행
            sendScheduledMailToGroup(testMail, request.getTarget_group_list(), true);

            // 예약 상태가 아니면 발송 성공 처리
            if (!"2".equals(request.getState_code())) {
                request.setState_code("1");  // 전체 발송 성공
            }
        } catch (Exception e) {
            request.setState_code("-1");  // 전체 발송 실패
            System.out.println("Send Mail Error" + e.getMessage());
        }

        // 2.5 Group insert
        try {
            List<SiteScheduledMailTargetGroup> targetGroups = new ArrayList<>();
            for (String id : request.getTarget_group_list()) {
                SiteScheduledMailTargetGroup group = SiteScheduledMailTargetGroup.builder()
                        .system_create_userid(request.getSystem_create_userid())
                        .mail_id(mail_id)
                        .group_id(id)
                        .build();
                targetGroups.add(group);
            }

            siteScheduledMailTargetGroupMapper.INSERT_ALL(targetGroups);
        } catch (Exception e) {
            System.out.println("siteScheduledMailTargetGroupMapper - INSERT_ALL fail" + e.getMessage());
            throw new RuntimeException("Failed to insert targetGroup into database", e);
        }


        return result;
    }

    //발송할 것인지 예약 분기 후 발송
    public void sendScheduledMailToGroup(Mail mail, List<String> targetGroup, Boolean isHtml) throws Exception {
        // 예약 시간이 없으면 즉시 전송
        if (mail.getScheduled_date() == null) {
            sendMailToGroup(mail, targetGroup, isHtml); //todo 너무오래걸림..로직바꿔야함
        } else {
            long delay = mail.getScheduled_date().getTime() - System.currentTimeMillis();
            if (delay > 0) {
                // 예약 시간이 아직 지나지 않았다면 그 시간만큼 지연 후 메일 전송
                ScheduledFuture<?> future = scheduler.schedule(() -> {
                    try {
                        sendMailToGroup(mail, targetGroup, isHtml); //메일 전송
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }, delay, TimeUnit.MILLISECONDS);

                // 예약된 작업을 Map에 저장 (Mail ID를 키로 사용)
                scheduledTasks.put(mail.getMail_id(), future);
            } else {
                // 이미 예약 시간이 지나버린 경우 즉시 메일 전송
                sendMailToGroup(mail, targetGroup, isHtml);
            }
        }
    }


    //todo sent TBL에 systimestamp가 발송요청 시간 기준으로 들어감

    // 그룹에 해당하는 유저를 찾아 이메일 리스트 생성 후 메일 전송 결과 반환
    public void sendMailToGroup(Mail mail, List<String> targetGroups, Boolean isHtml) throws Exception {
        boolean hasServerFailure = false;  // 서버 오류 여부를 체크할 변수

        if (targetGroups != null && !targetGroups.isEmpty()) {
            List<CommonUserGroup> userList = commonUserGroupMapper.SELECT_BY_GROUP_ID_LIST(targetGroups);

            if (userList == null || userList.isEmpty()) {
                System.out.println("No users found for the groups: " + targetGroups);
                return;
            }

            List<String> emailList = userList.stream()
                    .map(CommonUserGroup::getUser_email)
                    .collect(Collectors.toList());

            if (emailList.isEmpty()) {
                System.out.println("No emails found for the groups.");
                return;
            }

            try {
                // 비동기적으로 이메일 전송 및 결과 받기
                List<CompletableFuture<Map<String, String>>> futures = new ArrayList<>();

                for (String email : emailList) {
                    CompletableFuture<Map<String, String>> future = mailService.sendMailAsync(mail, email, isHtml);
                    futures.add(future);
                }

                // 모든 비동기 작업 완료 기다리기
                for (CompletableFuture<Map<String, String>> future : futures) {
                    Map<String, String> sendResults = future.get();  // 결과 대기

                    // 2. 발송 후 개별 Mail 기록 insert
                    for (Map.Entry<String, String> entry : sendResults.entrySet()) {
                        String email = entry.getKey();
                        String result = entry.getValue();

                        String stateCode;
                        String failureReason = null;

                        if ("SUCCESS".equals(result)) {
                            stateCode = "1";  // 성공
                        } else {
                            stateCode = "0";  // 실패
                            failureReason = "0";  // 실패 이유 기록
                        }

                        java.sql.Date sqlDate = new java.sql.Date(mail.getScheduled_date().getTime());

                        // log 생성 및 DB에 삽입
                        var log = SiteSentMailManagement.builder()
                                .mail_id(mail.getMail_id())
                                .state_code(stateCode)
                                .latest_from_email(senderEmail)
                                .system_create_userid("test@giens.co.kr")
                                .latest_to_email(email)
                                .failure_reason_code(failureReason)
                                .build();

                        siteSentMailManagementMapper.INSERT(log);
                    }
                }

            } catch (Exception e) {
                System.out.println("Failed to send email to one or more recipients");
                e.printStackTrace();
                hasServerFailure = true;
            }

            // 전체 발송 상태를 업데이트
            try {
                String overallStatus = hasServerFailure ? "0" : "1";  // 서버 오류가 발생하면 실패로, 아니면 성공으로
                var update = SiteScheduledMail.builder()
                        .mail_id(mail.getMail_id())
                        .state_code(overallStatus).build();
                siteScheduledMailMapper.UPDATE(update); // 발송 상태 업데이트
            } catch (Exception e) {
                System.out.println("Failed to update overall mail status: " + e.getMessage());
                throw new RuntimeException("Failed to update overall mail status", e);
            }
        }
    }


    //예약대기 중인 메일 삭제
    public void cancelScheduledMail(String mailId) {
        ScheduledFuture<?> future = scheduledTasks.get(mailId);
        if (future != null) {
            // 작업 취소
            future.cancel(false);
            scheduledTasks.remove(mailId);
        } else {
            System.out.println("No scheduled Mail: " + mailId);
        }
    }
    
    //재발송 시도
    public int resendMail(SiteScheduledMail request) {
        int result = 0;
        //다시 발송
        SiteScheduledMailTargetGroup group = new SiteScheduledMailTargetGroup();
        group.setMail_id(request.getMail_id());
        List<SiteScheduledMailTargetGroup> targetGroups = siteScheduledMailTargetGroupMapper.SELECT(group);

        List<String> list = new ArrayList<>();
        targetGroups.forEach(target -> {
            list.add(target.getGroup_id());
        });

        var mail = Mail.builder()
                .mail_id(request.getMail_id())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        try {
            sendMailToGroup(mail, list, true); //메일 전송

            //UPDATE param setting
            request.setState_code("1");
            request.setFailure_reason_code(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //UPDATE
        siteScheduledMailMapper.UPDATE(request);

        return result;
    }



}