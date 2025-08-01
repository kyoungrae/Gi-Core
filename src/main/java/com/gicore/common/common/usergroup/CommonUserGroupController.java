package com.gicore.common.common.usergroup;

import com.gicore.common.common.AbstractCommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common/common/commonUserGroup")
@RequiredArgsConstructor
public class CommonUserGroupController extends AbstractCommonController<CommonUserGroup> {

	private final CommonUserGroupService commonUserGroupService;
    private final CommonUserGroupRepository commonUserGroupRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody CommonUserGroup reqeust) throws Exception{
        return commonUserGroupService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<CommonUserGroup> findAll(@RequestBody CommonUserGroup request) throws Exception{
        return commonUserGroupRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<CommonUserGroup> findImpl(@RequestBody CommonUserGroup request) throws Exception{
        return commonUserGroupService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody CommonUserGroup request) {
        return commonUserGroupService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody CommonUserGroup request) {
        return commonUserGroupService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody CommonUserGroup request) throws Exception {
        return commonUserGroupService.registerImpl(request);
    }
}