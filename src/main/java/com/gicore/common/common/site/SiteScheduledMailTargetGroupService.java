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
public class SiteScheduledMailTargetGroupService extends AbstractCommonService<SiteScheduledMailTargetGroup> {
    private final SiteScheduledMailTargetGroupMapper siteScheduledMailTargetGroupMapper;
    private final SiteScheduledMailTargetGroupRepository siteScheduledMailTargetGroupRepository;
    private final MessageSource messageSource;

     private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SiteScheduledMailTargetGroup> selectPage(SiteScheduledMailTargetGroup request) throws Exception {
        return siteScheduledMailTargetGroupMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SiteScheduledMailTargetGroup request) throws Exception {
        return siteScheduledMailTargetGroupMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<SiteScheduledMailTargetGroup> findImpl(SiteScheduledMailTargetGroup request) throws Exception {
        return siteScheduledMailTargetGroupMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(SiteScheduledMailTargetGroup request) {
        return siteScheduledMailTargetGroupMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(SiteScheduledMailTargetGroup request) {
        return siteScheduledMailTargetGroupMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(SiteScheduledMailTargetGroup request){
        return siteScheduledMailTargetGroupMapper.INSERT(request);
    }
}