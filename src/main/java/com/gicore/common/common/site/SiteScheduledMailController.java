package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common/site/siteScheduledMail")
@RequiredArgsConstructor
public class SiteScheduledMailController extends AbstractCommonController<SiteScheduledMail> {

	private final SiteScheduledMailService siteScheduledMailService;
    private final SiteScheduledMailRepository siteScheduledMailRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody SiteScheduledMail reqeust) throws Exception{
        return siteScheduledMailService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SiteScheduledMail> findAll(@RequestBody SiteScheduledMail request) throws Exception{
        return siteScheduledMailRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SiteScheduledMail> findImpl(@RequestBody SiteScheduledMail request) throws Exception{
        return siteScheduledMailService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SiteScheduledMail request) {
        return siteScheduledMailService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SiteScheduledMail request) {
        return siteScheduledMailService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SiteScheduledMail request) throws Exception {
        return siteScheduledMailService.registerImpl(request);
    }

    @PostMapping("/resend")
    protected int resendMail(@RequestBody SiteScheduledMail request) {
        return siteScheduledMailService.resendMail(request);
    }
}