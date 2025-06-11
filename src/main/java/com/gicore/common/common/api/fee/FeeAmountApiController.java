package com.gicore.common.common.api.fee;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/fee/feeAmount")
@RestController
@AllArgsConstructor
public class FeeAmountApiController {

    private final FeeAmountApiService feeAmountApiService;
    @PostMapping("/find")
    public List<Map<String,Object>> find(@RequestBody Map<String,Object> param ,HttpServletRequest request) throws Exception{
        return feeAmountApiService.find(param,request);
    }

}
