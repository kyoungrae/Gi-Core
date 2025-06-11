/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonService;
import com.gicore.common.common.mail.Mail;
import com.gicore.common.common.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SiteSentMailManagementService extends AbstractCommonService<SiteSentMailManagement> {
    private final SiteSentMailManagementMapper siteSentMailManagementMapper;
    private final SiteSentMailManagementRepository siteSentMailManagementRepository;
    private final SiteScheduledMailMapper siteScheduledMailMapper;
    private final MailService mailService;
    private final MessageSource messageSource;

     private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SiteSentMailManagement> selectPage(SiteSentMailManagement request) throws Exception {
        return siteSentMailManagementMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SiteSentMailManagement request) throws Exception {
        return siteSentMailManagementMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<SiteSentMailManagement> findImpl(SiteSentMailManagement request) throws Exception {
        return siteSentMailManagementMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(SiteSentMailManagement request) {
        return siteSentMailManagementMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(SiteSentMailManagement request) {
        return siteSentMailManagementMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(SiteSentMailManagement request){
        return siteSentMailManagementMapper.INSERT(request);
    }

    public int resendSingleMail(SiteSentMailManagement request){
        int result = 0;

        try {
            // 메일 조회
            List<SiteSentMailManagement> originalMail = siteSentMailManagementMapper.SELECT_WITH_MAIL_AND_USER(request);
            if (originalMail.isEmpty()) {
                throw new RuntimeException("Not Exist Mail: "+ request.getMail_id());
            }

            // 이메일 목록 생성 (여기선 1개의 이메일만 재발송)
            List<String> email = new ArrayList<>();
            email.add(originalMail.get(0).getEmail());

            // 메일 객체 생성
            var mail = Mail.builder()
                    .mail_id(request.getMail_id())
                    .content(originalMail.get(0).getContent())
                    .title(originalMail.get(0).getTitle())
                    .email_list(email)
                    .build();


            try {
                //1. 메일 발송
                mailService.sendMail(mail, true); // 메일 발송

                //2. update param setting (성공 시 1)
                request.setState_code("1");
            } catch(Exception e) {
                System.out.println("메일 발송 실패: " + e.getMessage());  
            }

            request.setLatest_to_email(mail.getEmail_list().get(0));
            request.setLatest_sent_date(new Date(System.currentTimeMillis()));
            request.setFailure_reason_code(null);
            //request.setLatest_from_email(); 바뀐다면 추가

            //3. UPDATE
            result = siteSentMailManagementMapper.UPDATE(request);

        } catch (Exception e) {
            return -1;
        }
        return result;
    }



}