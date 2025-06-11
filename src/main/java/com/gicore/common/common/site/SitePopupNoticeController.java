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
@RequestMapping("/common/site/sitePopupNotice")
@RequiredArgsConstructor
public class SitePopupNoticeController extends AbstractCommonController<SitePopupNotice> {

	private final SitePopupNoticeService sitePopupNoticeService;
    private final SitePopupNoticeRepository sitePopupNoticeRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody SitePopupNotice reqeust) throws Exception{
        return sitePopupNoticeService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SitePopupNotice> findAll(@RequestBody SitePopupNotice request) throws Exception{
        return sitePopupNoticeRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SitePopupNotice> findImpl(@RequestBody SitePopupNotice request) throws Exception{
        return sitePopupNoticeService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SitePopupNotice request) {
        return sitePopupNoticeService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SitePopupNotice request) {
        return sitePopupNoticeService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SitePopupNotice request) throws Exception {
        return sitePopupNoticeService.registerImpl(request);
    }

    @PostMapping("/registerNoticeWithTargetGroup")
    protected int registerNoticeWithTargetGroup(@RequestBody SitePopupNotice request) throws Exception {
        return sitePopupNoticeService.registerNoticeWithTargetGroup(request);
    }

    @PostMapping("/selectNoticeWithTargetGroup")
    protected List<Map<String,Object>> selectWithTargetGroup(@RequestBody SitePopupNotice request) throws Exception {
        return sitePopupNoticeService.selectNoticeWithTargetGroup(request);
    }

    @PostMapping("/findNoticeByUserGroup")
    protected List<Map<String,Object>> findNoticeByUserGroup(@RequestBody SitePopupNotice request) throws Exception {
        return sitePopupNoticeService.findNoticeByUserGroup(request);
    }

    @PostMapping("/updateNoticeWithTargetGroup")
    protected int updateNoticeWithTargetGroup(@RequestBody SitePopupNotice request) throws Exception {
        return sitePopupNoticeService.updateNoticeWithTargetGroup(request);
    }
}