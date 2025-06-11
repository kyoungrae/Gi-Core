package com.gicore.common.util.receipt;

import com.gicore.common.util.userinfo.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class testController {
    private final ApplicationReceiptNumberManagementMapper applicationReceiptNumberManagementMapper;

    @PostMapping("/test")
    public String test(HttpServletRequest request) throws Exception{
//        ReciptNumber reciptNumber = new ReciptNumber(applicationReceiptNumberManagementMapper);
//        reciptNumber.getReciptNumber("101");
//        System.out.println(reciptNumber.getReciptNumber("101"));
        UserInfo userInfo = new UserInfo();
        System.out.println(userInfo.getUserEmail());
        return "";
    }
}
