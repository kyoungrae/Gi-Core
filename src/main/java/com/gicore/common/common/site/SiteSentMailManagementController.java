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
@RequestMapping("/common/site/siteSentMailManagement")
@RequiredArgsConstructor
public class SiteSentMailManagementController extends AbstractCommonController<SiteSentMailManagement> {

	private final SiteSentMailManagementService siteSentMailManagementService;
    private final SiteSentMailManagementRepository siteSentMailManagementRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody SiteSentMailManagement reqeust) throws Exception{
        return siteSentMailManagementService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<SiteSentMailManagement> findAll(@RequestBody SiteSentMailManagement request) throws Exception{
        return siteSentMailManagementRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<SiteSentMailManagement> findImpl(@RequestBody SiteSentMailManagement request) throws Exception{
        return siteSentMailManagementService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody SiteSentMailManagement request) {
        return siteSentMailManagementService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody SiteSentMailManagement request) {
        return siteSentMailManagementService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody SiteSentMailManagement request) {
        return siteSentMailManagementService.registerImpl(request);
    }

    @PostMapping("/resendSingle")
    protected int resendSingleMail(@RequestBody SiteSentMailManagement request) {
        return siteSentMailManagementService.resendSingleMail(request);
    }
}