package com.gicore.common.common.guide;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guide")
public class GuideController {
    private final GuideService guideService;
    @PostMapping("/readFile")
    protected String readCommonJsFile(@RequestBody Map<String,Object> param) throws Exception {

        return guideService.readFile(param);
    }
}
