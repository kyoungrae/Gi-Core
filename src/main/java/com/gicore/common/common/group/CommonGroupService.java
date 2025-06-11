/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.group;

import com.gicore.common.common.AbstractCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonGroupService extends AbstractCommonService<CommonGroup> {
    private final CommonGroupMapper commonGroupMapper;
    private final CommonGroupRepository commonGroupRepository;

    @Override
    protected List<CommonGroup> selectPage(CommonGroup request) throws Exception {
        return commonGroupMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(CommonGroup request) throws Exception {
        return commonGroupMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<CommonGroup> findImpl(CommonGroup request) throws Exception {
        return commonGroupMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(CommonGroup request) {
        return commonGroupMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(CommonGroup request) {
        return commonGroupMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(CommonGroup request) {
        return commonGroupMapper.INSERT(request);
    }
}