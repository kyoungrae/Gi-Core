package com.gicore.common.common.menu;

import com.gicore.common.common.AbstractCommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common/menu/commonAccessGroupMenuList")
@RequiredArgsConstructor
public class CommonAccessGroupMenuListController extends AbstractCommonController<CommonAccessGroupMenuList> {

	private final CommonAccessGroupMenuListService commonAccessGroupMenuListService;
    private final CommonAccessGroupMenuListRepository commonAccessGroupMenuListRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody CommonAccessGroupMenuList reqeust) throws Exception{
        return commonAccessGroupMenuListService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<CommonAccessGroupMenuList> findAll(@RequestBody CommonAccessGroupMenuList request) throws Exception{
        return commonAccessGroupMenuListRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<CommonAccessGroupMenuList> findImpl(@RequestBody CommonAccessGroupMenuList request) throws Exception{
        return commonAccessGroupMenuListService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody CommonAccessGroupMenuList request) {
        return commonAccessGroupMenuListService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody CommonAccessGroupMenuList request) {
        return commonAccessGroupMenuListService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody CommonAccessGroupMenuList request) {
        return commonAccessGroupMenuListService.registerImpl(request);
    }

    @PostMapping("/updateAccessGroups")
    protected int updateAccessGroups(@RequestBody CommonAccessGroupMenuList request) {
        return commonAccessGroupMenuListService.updateAccessGroups(request);
    }

}