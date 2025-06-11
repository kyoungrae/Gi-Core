/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.office;

import com.gicore.common.common.AbstractCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonOfficeService extends AbstractCommonService<CommonOffice> {
    private final CommonOfficeMapper commonOfficeMapper;
    private final CommonOfficeRepository commonOfficeRepository;

    @Override
    protected List<CommonOffice> selectPage(CommonOffice request) throws Exception {
        return commonOfficeMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(CommonOffice request) throws Exception {
        return commonOfficeMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<CommonOffice> findImpl(CommonOffice request) throws Exception {
        return commonOfficeMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(CommonOffice request) {
        return commonOfficeMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(CommonOffice request) {
        return commonOfficeMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(CommonOffice request) {
        return commonOfficeMapper.INSERT(request);
    }
}