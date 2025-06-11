package com.gicore.common.common.user;

import com.gicore.common.common.AbstractCommonController;
import com.gicore.common.common.site.SiteConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common/common/commonUser")
@RequiredArgsConstructor
public class CommonUserController extends AbstractCommonController<User> {

	private final CommonUserService commonUserService;
    private final CommonUserRepository commonUserRepository;
    private final SiteConfigService siteConfigService;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody CommonUser reqeust) throws Exception{
        return commonUserService.findPage(reqeust);
    }

    @PostMapping("/findJoinInspectionStationInspectorPage")
    public Map<String,List<?>> findJoinInspectionStationInspectorPage(@RequestBody CommonUser reqeust) throws Exception{
        return commonUserService.findJoinInspectionStationInspectorPage(reqeust);
    }

    @PostMapping("/findJoinCommonUserGroupPage")
    public Map<String,List<?>> findJoinCommonUserGroupPage(@RequestBody CommonUser reqeust) throws Exception{
        return commonUserService.findJoinCommonUserGroupPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<User> findAll(@RequestBody User request) throws Exception{
        return commonUserRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<User> findImpl(@RequestBody User request) throws Exception{
        return commonUserService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody User request) throws Exception {
        return commonUserService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody User request) {
        return commonUserService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody User request) {
        return commonUserService.registerImpl(request);
    }
    @PostMapping("/matchToPassword")
    public boolean matchToPassword(@RequestBody CommonUser request){
        return commonUserService.matchToPassword(request);
    }

    @PostMapping("/getUserImageUrlByUserEmail")
    protected String getUserImageUrlByUserEmail(@RequestBody CommonUser request) throws Exception{
        return commonUserService.getUserImageUrlByUserEmail(request.getEmail());
    }

    @PostMapping("/changePassword")
    public int changePassword(@RequestBody CommonUser request) {
        return commonUserService.changePassword(request);
    }

    @PostMapping("/validatePasswordPolicy")
    public List<String> validatePasswordPolicy(@RequestBody String request) {
        return commonUserService.validatePasswordPolicy(request);
    }

    @PostMapping("/initializePassword")
    public int initializePassword(@RequestBody CommonUser request) {
        return commonUserService.initializePassword(request);
    }
}