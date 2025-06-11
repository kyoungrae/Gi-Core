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
@RequestMapping("/common/site/siteConfigHistory")
@RequiredArgsConstructor
public class SiteConfigHistoryController extends AbstractCommonController<SiteConfigHistory> {

	private final SiteConfigHistoryService siteConfigHistoryService;
    private final SiteConfigHistoryRepository siteConfigHistoryRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody SiteConfigHistory reqeust) throws Exception{
        return siteConfigHistoryService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SiteConfigHistory> findAll(@RequestBody SiteConfigHistory request) throws Exception{
        return siteConfigHistoryRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SiteConfigHistory> findImpl(@RequestBody SiteConfigHistory request) throws Exception{
        return siteConfigHistoryService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SiteConfigHistory request) {
        return siteConfigHistoryService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SiteConfigHistory request) {
        return siteConfigHistoryService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SiteConfigHistory request) {
        return siteConfigHistoryService.registerImpl(request);
    }
}