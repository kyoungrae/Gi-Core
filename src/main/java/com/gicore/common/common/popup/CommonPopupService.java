/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.popup;

import com.gicore.common.common.AbstractCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonPopupService extends AbstractCommonService<CommonPopup> {
    private final CommonPopupMapper commonPopupMapper;
    private final CommonPopupRepository commonPopupRepository;

    protected List<CommonPopup> findCommonPopup(CommonPopup request) throws Exception {
        try{
            return commonPopupMapper.SELECT(request);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    protected List<CommonPopup> selectPage(CommonPopup request) throws Exception {
        return commonPopupMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(CommonPopup request) throws Exception {
        return commonPopupMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<CommonPopup> findImpl(CommonPopup request) throws Exception {
        return commonPopupMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(CommonPopup request) {
        return commonPopupMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(CommonPopup request) {
        return commonPopupMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(CommonPopup request) {
        return commonPopupMapper.INSERT(request);
    }
}