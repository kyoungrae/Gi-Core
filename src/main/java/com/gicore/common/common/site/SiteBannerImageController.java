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
@RequestMapping("/common/site/siteBannerImage")
@RequiredArgsConstructor
public class SiteBannerImageController extends AbstractCommonController<SiteBannerImage> {

    private final SiteBannerImageService siteBannerImageService;
    private final SiteBannerImageRepository siteBannerImageRepository;

    @PostMapping("/findPage")
    public Map<String, List<?>> findPage(@RequestBody SiteBannerImage reqeust) throws Exception {
        return siteBannerImageService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SiteBannerImage> findAll(@RequestBody SiteBannerImage request) throws Exception {
        return siteBannerImageRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SiteBannerImage> findImpl(@RequestBody SiteBannerImage request) throws Exception {
        return siteBannerImageService.findImpl(request);
    }

    @PostMapping("/findWithFile")
    protected List<Map<String, Object>> findWithFile(@RequestBody SiteBannerImage request) throws Exception {
        return siteBannerImageService.findWithFile(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SiteBannerImage request) {
        return siteBannerImageService.removeImpl(request);
    }

    @PostMapping("/removeAndShift")
    protected int removeAndShift(@RequestBody SiteBannerImage request) {
        return siteBannerImageService.removeAndShift(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SiteBannerImage request) {
        return siteBannerImageService.updateImpl(request);
    }

    @PostMapping("/reorder")
    protected int reorder(@RequestBody List<SiteBannerImage> request) {
        return siteBannerImageService.reorder(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SiteBannerImage request) {
        return siteBannerImageService.registerImpl(request);
    }
}