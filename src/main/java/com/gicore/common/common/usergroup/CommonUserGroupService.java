/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.usergroup;

import com.gicore.common.common.AbstractCommonService;
import com.gicore.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonUserGroupService extends AbstractCommonService<CommonUserGroup> {
    private final CommonUserGroupMapper commonUserGroupMapper;
    private final CommonUserGroupRepository commonUserGroupRepository;
    private final MessageSource messageSource;

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
    @Override
    protected List<CommonUserGroup> selectPage(CommonUserGroup request) throws Exception {
        return commonUserGroupMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(CommonUserGroup request) throws Exception {
        return commonUserGroupMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<CommonUserGroup> findImpl(CommonUserGroup request) throws Exception {
        return commonUserGroupMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(CommonUserGroup request) {
        return commonUserGroupMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(CommonUserGroup request) {
        return commonUserGroupMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(CommonUserGroup request) throws Exception{
        int rtn = 0;
        try {
            rtn = commonUserGroupMapper.INSERT(request);
        }catch (Exception e){
            throw new CustomException(getMessage("EXCEPTION.PK.EXIST.USER"));
        }
        return rtn;
    }
}