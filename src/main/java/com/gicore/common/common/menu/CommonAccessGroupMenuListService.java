/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.menu;

import com.gicore.common.common.AbstractCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonAccessGroupMenuListService extends AbstractCommonService<CommonAccessGroupMenuList> {
    private final CommonAccessGroupMenuListMapper commonAccessGroupMenuListMapper;
    private final CommonAccessGroupMenuListRepository commonAccessGroupMenuListRepository;
    private final MessageSource messageSource;

     private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<CommonAccessGroupMenuList> selectPage(CommonAccessGroupMenuList request) throws Exception {
        return commonAccessGroupMenuListMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(CommonAccessGroupMenuList request) throws Exception {
        return commonAccessGroupMenuListMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<CommonAccessGroupMenuList> findImpl(CommonAccessGroupMenuList request) throws Exception {
        return commonAccessGroupMenuListMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(CommonAccessGroupMenuList request) {
        return commonAccessGroupMenuListMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(CommonAccessGroupMenuList request) {
        return commonAccessGroupMenuListMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(CommonAccessGroupMenuList request){
        return commonAccessGroupMenuListMapper.INSERT(request);
    }

    protected int updateAccessGroups(CommonAccessGroupMenuList request){
        List<String> accessRightGroupList;

        if (request.getAccess_right_group().contains(",")) {
            accessRightGroupList = Arrays.asList(request.getAccess_right_group().split(",\\s*"));
        } else {
            accessRightGroupList = Collections.singletonList(request.getAccess_right_group());
        }

        commonAccessGroupMenuListMapper.DELETE_ALL(request);

        int result=0;

        if (accessRightGroupList != null && !accessRightGroupList.isEmpty()) {
            for (String id : accessRightGroupList) {
                if (id != null && !id.trim().isEmpty()) {
                    request.setAccess_rights_group_id(id);
                    result += commonAccessGroupMenuListMapper.INSERT(request);
                }
            }
        }

        return result;

    //return commonAccessGroupMenuListMapper.INSERT(request);
}



}