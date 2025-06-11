package com.gicore.common.common.mail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/sendMail")
    public ResponseEntity<Void> sendMail(@RequestBody Mail mail) {
        try {
            // 메일 발송 서비스 호출
            mailService.sendMail(mail, true);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // 500 Internal Server Error 응답
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}