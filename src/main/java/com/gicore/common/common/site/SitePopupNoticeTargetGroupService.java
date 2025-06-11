/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SitePopupNoticeTargetGroupService extends AbstractCommonService<SitePopupNoticeTargetGroup> {
    private final SitePopupNoticeTargetGroupMapper sitePopupNoticeTargetGroupMapper;
    private final SitePopupNoticeTargetGroupRepository sitePopupNoticeTargetGroupRepository;
    private final MessageSource messageSource;

     private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SitePopupNoticeTargetGroup> selectPage(SitePopupNoticeTargetGroup request) throws Exception {
        return sitePopupNoticeTargetGroupMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SitePopupNoticeTargetGroup request) throws Exception {
        return sitePopupNoticeTargetGroupMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<SitePopupNoticeTargetGroup> findImpl(SitePopupNoticeTargetGroup request) throws Exception {
        return sitePopupNoticeTargetGroupMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(SitePopupNoticeTargetGroup request) {
        return sitePopupNoticeTargetGroupMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(SitePopupNoticeTargetGroup request) {
        return sitePopupNoticeTargetGroupMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(SitePopupNoticeTargetGroup request){
        return sitePopupNoticeTargetGroupMapper.INSERT(request);
    }
}