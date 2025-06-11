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
@RequestMapping("/common/site/siteScheduledMailTargetGroup")
@RequiredArgsConstructor
public class SiteScheduledMailTargetGroupController extends AbstractCommonController<SiteScheduledMailTargetGroup> {

	private final SiteScheduledMailTargetGroupService siteScheduledMailTargetGroupService;
    private final SiteScheduledMailTargetGroupRepository siteScheduledMailTargetGroupRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody SiteScheduledMailTargetGroup reqeust) throws Exception{
        return siteScheduledMailTargetGroupService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SiteScheduledMailTargetGroup> findAll(@RequestBody SiteScheduledMailTargetGroup request) throws Exception{
        return siteScheduledMailTargetGroupRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SiteScheduledMailTargetGroup> findImpl(@RequestBody SiteScheduledMailTargetGroup request) throws Exception{
        return siteScheduledMailTargetGroupService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SiteScheduledMailTargetGroup request) {
        return siteScheduledMailTargetGroupService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SiteScheduledMailTargetGroup request) {
        return siteScheduledMailTargetGroupService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SiteScheduledMailTargetGroup request) {
        return siteScheduledMailTargetGroupService.registerImpl(request);
    }
}