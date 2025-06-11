package com.gicore.common.common.menu;

import com.gicore.common.common.AbstractCommonService;
import com.gicore.common.common.usergroup.CommonUserGroupMapper;
import com.gicore.common.util.userinfo.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MenuService extends AbstractCommonService<Menu> {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;
    private final CommonAccessGroupMenuListMapper commonAccessGroupMenuListMapper;
    private final CommonUserGroupMapper commonUserGroupMapper;

    @Override
    protected List<Menu> selectPage(Menu request) throws Exception {
        return menuMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(Menu request) throws Exception {
        return menuMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<Menu> findImpl(Menu request) throws Exception {
        return menuMapper.SELECT(request);
    }
    public List<Menu> findHierarchy(Menu request) throws Exception {
        //return menuMapper.SELECT_HIERARCHY(request);
        return menuMapper.SELECT_HIERARCHY_WITH_ACCESS_RIGHT_GROUP(request);
    }

    @Override
    protected int removeImpl(Menu request) {
        return menuMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(Menu request) throws Exception {

//        List<String> accessRightGroupList;
//
//        if (request.getAccess_right_group().contains(",")) {
//            accessRightGroupList = Arrays.asList(request.getAccess_right_group().split(",\\s*"));
//        } else {
//            accessRightGroupList = Collections.singletonList(request.getAccess_right_group());
//        }
//        // access right group menu list 테이블 - 해당 MENU_CODE 내용 다 지우고 새로 insert
//        DeleteInsertCommonAccessGroupMenuList(request, accessRightGroupList);

        return menuMapper.UPDATE(request);
        //return 0;
    }

    @Transactional
    public int DeleteInsertCommonAccessGroupMenuList(Menu request,
                                                     List<String> accessRightGroupList) throws Exception {

        var commonAccessGroupMenuList = CommonAccessGroupMenuList.builder()
                        .menu_code(request.getMenu_code())
                                .build();
        commonAccessGroupMenuListMapper.DELETE_ALL(commonAccessGroupMenuList);

        int result=0;

        if (accessRightGroupList != null && !accessRightGroupList.isEmpty()) {
            for (String id : accessRightGroupList) {
                if (id != null && !id.trim().isEmpty()) {
                    commonAccessGroupMenuList.setAccess_rights_group_id(id);
                    result += commonAccessGroupMenuListMapper.INSERT(commonAccessGroupMenuList);
                }
            }
        }

        return result;
    }

    @Override
    protected int registerImpl(Menu request) {
        return menuMapper.INSERT(request);
    }

    public int removeMenuCode(Menu request) throws Exception{
        var containTopMenuCode = Menu.builder()
                .top_menu_code(request.getMenu_code())
                .build();
        var containMenuCode = Menu.builder()
                .menu_code(request.getMenu_code())
                .build();
        List<Menu> list = menuMapper.SELECT(containTopMenuCode);
        boolean childNodeExist = !list.isEmpty();
        try {
            if(childNodeExist){
                 return -1;
            }else{
                return menuMapper.DELETE(containMenuCode);
            }
        }catch (Exception e){
            throw new Exception("FAIL TO REMOVE MENU");
        }
    }

    public List<Menu> findJoinCommonAccessGroupMenuList(Menu request) throws Exception{
        UserInfo userInfo = new UserInfo();
        String userEmail = userInfo.getUserEmail();

        var menu = Menu.builder()
                .user_email(userEmail)
                .build();

        return menuMapper.SELECT_JOIN_COMMON_ACCESS_GROUP_MENU_LIST(menu);
    }

    /*
    public List<Menu> findJoinCommonAccessGroupMenuList(Menu request) throws Exception{
        UserInfo userInfo = new UserInfo();
        String userEmail = userInfo.getUserEmail();

        var commonUserGroup = CommonUserGroup.builder()
                .user_email(userEmail)
                .build();

        List<CommonUserGroup> commonUserGroupsList = commonUserGroupMapper.SELECT(commonUserGroup);

        var menuBean = Menu.builder()
                .build();
        menuBean = request;
        menuBean.setAccess_rights_group_id(commonUserGroupsList.get(0).getGroup_id());

        return menuMapper.SELECT_JOIN_COMMON_ACCESS_GROUP_MENU_LIST(menuBean);
    }
    */
}
