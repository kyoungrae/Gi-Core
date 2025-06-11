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
@RequestMapping("/common/site/sitePopupNoticeTargetGroup")
@RequiredArgsConstructor
public class SitePopupNoticeTargetGroupController extends AbstractCommonController<SitePopupNoticeTargetGroup> {

	private final SitePopupNoticeTargetGroupService sitePopupNoticeTargetGroupService;
    private final SitePopupNoticeTargetGroupRepository sitePopupNoticeTargetGroupRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody SitePopupNoticeTargetGroup reqeust) throws Exception{
        return sitePopupNoticeTargetGroupService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SitePopupNoticeTargetGroup> findAll(@RequestBody SitePopupNoticeTargetGroup request) throws Exception{
        return sitePopupNoticeTargetGroupRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SitePopupNoticeTargetGroup> findImpl(@RequestBody SitePopupNoticeTargetGroup request) throws Exception{
        return sitePopupNoticeTargetGroupService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SitePopupNoticeTargetGroup request) {
        return sitePopupNoticeTargetGroupService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SitePopupNoticeTargetGroup request) {
        return sitePopupNoticeTargetGroupService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SitePopupNoticeTargetGroup request) {
        return sitePopupNoticeTargetGroupService.registerImpl(request);
    }
}