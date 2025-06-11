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
public class SiteConfigHistoryService extends AbstractCommonService<SiteConfigHistory> {
    private final SiteConfigHistoryMapper siteConfigHistoryMapper;
    private final SiteConfigHistoryRepository siteConfigHistoryRepository;
    private final MessageSource messageSource;

     private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SiteConfigHistory> selectPage(SiteConfigHistory request) throws Exception {
        return siteConfigHistoryMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SiteConfigHistory request) throws Exception {
        return siteConfigHistoryMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<SiteConfigHistory> findImpl(SiteConfigHistory request) throws Exception {
        return siteConfigHistoryMapper.SELECT(request);
    }

    @Override
    protected int removeImpl(SiteConfigHistory request) {
        return siteConfigHistoryMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(SiteConfigHistory request) {
        return siteConfigHistoryMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(SiteConfigHistory request){
        return siteConfigHistoryMapper.INSERT(request);
    }
}