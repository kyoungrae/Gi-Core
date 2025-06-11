package com.gicore.common.common.api.util;

import com.gicore.common.util.DateUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/common/util")
public class CommonUtilController {
    @PostMapping("/getServerTime")
    public Map<String, String> getServerTime(){
        return DateUtil.getServerTime();
    }
}
