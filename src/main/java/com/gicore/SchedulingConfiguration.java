package com.gicore;

import com.gicore.common.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.UUID;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulingConfiguration {

    @Scheduled(cron = "0 0 0 * * ?") // 매일 자정(24:00)에 실행
//    @Scheduled(fixedRate = 5000) // 5초 마다 실행 -- 테스트용
    public void scheduleRegisterInspectionTargetNoticeTask(){
        String noticeId = String.valueOf(UUID.randomUUID());
        String nowDate = DateUtil.LocalDate("yyyyMMdd");
        String before30Day = DateUtil.addOrSubtractDate(nowDate,0,0,0);
    }
}
