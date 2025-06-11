package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonController;
import com.gicore.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/common/site/siteConfig")
@RequiredArgsConstructor
public class SiteConfigController extends AbstractCommonController<SiteConfig> {

    private final SiteConfigService siteConfigService;
    private final SiteConfigRepository siteConfigRepository;

    @PostMapping("/findPage")
    public Map<String, List<?>> findPage(@RequestBody SiteConfig reqeust) throws Exception {
        return siteConfigService.findPage(reqeust);
    }

    @PostMapping("/findGroupPage")
    public Map<String, List<?>> findGroupPage(@RequestBody SiteConfig reqeust) throws Exception {
        return siteConfigService.findGroupPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SiteConfig> findAll(@RequestBody SiteConfig request) throws Exception {
        return siteConfigRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SiteConfig> findImpl(@RequestBody SiteConfig request) throws Exception {
        return siteConfigService.findImpl(request);
    }

    @PostMapping("/findGroup")
    public String[] findGroup() throws Exception {
        return siteConfigService.findGroup();
    }

    @PostMapping("/findValuesByKeys")
    protected Map<String, String> findValuesByKeys(@RequestBody List<String> request) throws Exception {
        return siteConfigService.findValuesByKeys(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SiteConfig request) {
        return siteConfigService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SiteConfig request) {
        return siteConfigService.updateImpl(request);
    }

    @PostMapping("/merge")
    protected int merge(@RequestBody SiteConfig request) {
        return siteConfigService.merge(request);
    }

    @PostMapping("/mergeList")
    protected int mergeList(@RequestBody List<SiteConfig> request) {
        return siteConfigService.merge(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SiteConfig request) {
        return siteConfigService.registerImpl(request);
    }

    @PostMapping("/registerWithConflictCheck")
    protected int registerWithConflictCheck(@RequestBody SiteConfig request) {
        try {
            return siteConfigService.registerImpl(request);
        } catch (DuplicateKeyException e) {
            throw new CustomException("IS_ALREADY_EXISTS");
        }
    }
}