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
@RequestMapping("/common/menu")
@RequiredArgsConstructor
public class MenuController extends AbstractCommonController<Menu> {
    private final MenuService menuService;
    private final MenuRepository menuRepository;

    @PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody Menu reqeust) throws Exception{
        return menuService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<Menu> findAll(@RequestBody Menu request) throws Exception{
        return menuRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<Menu> findImpl(@RequestBody Menu request) throws Exception{
        return menuService.findImpl(request);
    }
    @PostMapping("/findJoinCommonAccessGroupMenuList")
    protected List<Menu> findJoinCommonAccessGroupMenuList(@RequestBody Menu request) throws Exception{
        return menuService.findJoinCommonAccessGroupMenuList(request);
    }
    @PostMapping("/findHierarchy")
    public List<Menu> findHierarchy(@RequestBody Menu request) throws Exception{
        return menuService.findHierarchy(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody Menu request){
        return menuService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody Menu request) throws Exception {
        return menuService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody Menu request) {
        return menuService.registerImpl(request);
    }

    @PostMapping("/removeMenuCode")
    public int removeMenuCode(@RequestBody Menu request) throws Exception{
        return menuService.removeMenuCode(request);
    }
}
