package com.gicore.common.common.mail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${spring.mail.username}")  // application.properties에 설정한 값으로 주입
    private String senderEmail;
    private final JavaMailSender javaMailSender;

    // todo 첨부파일 & 인라인이미지 처리 필요
    //emailList를 넘겨 메일 발송 하는 메서드.
    public void sendMail(Mail mail, Boolean isHtml) throws Exception {
        List<String> emails = mail.getEmail_list();

        // 이메일 리스트가 비어있으면 종료
        if (emails == null || emails.isEmpty()) {
            System.out.println("No email list");
            return;
        }

        // 메일 전송
        for (String email : emails) {
            try {
                MimeMessagePreparator preparatory = mimeMessage -> {
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
                    String content = mail.getContent();
                    helper.setTo(email);
                    helper.setFrom(senderEmail);
                    helper.setSubject(mail.getTitle());
                    helper.setText(content, isHtml); // HTML 전송
                };

                javaMailSender.send(preparatory);

            } catch (Exception e) {
                throw new Exception("Failed to send email: " + email, e);
            }
        }
    }


    // 속도 이슈로 비동기 처리
    @Async
    public CompletableFuture<Map<String, String>> sendMailAsync(Mail mail, String email, Boolean isHtml) {
        Map<String, String> result = new HashMap<>();
        try {
            MimeMessagePreparator preparatory = mimeMessage -> {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
                String content = mail.getContent();
                helper.setTo(email);
                helper.setFrom(senderEmail);
                helper.setSubject(mail.getTitle());
                helper.setText(content, isHtml); // HTML 전송
            };

            javaMailSender.send(preparatory); // 이메일 전송

            // 성공 시 결과 저장
            result.put(email, "SUCCESS");

        } catch (Exception e) {
            // 실패 시 결과 저장
            result.put(email, "FAILED: " + e.getMessage());
        }
        return CompletableFuture.completedFuture(result);
    }
}

