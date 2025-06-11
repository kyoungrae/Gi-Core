/**
 * ++ giens Product ++
 */
package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonService;
import com.gicore.common.util.passwordvalidation.PasswordPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SiteConfigService extends AbstractCommonService<SiteConfig> {
    private final SiteConfigMapper siteConfigMapper;
    private final SiteConfigRepository siteConfigRepository;
    private final MessageSource messageSource;

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SiteConfig> selectPage(SiteConfig request) throws Exception {
        return siteConfigMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SiteConfig request) throws Exception {
        return siteConfigMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }

    public Map<String, List<?>> findGroupPage(SiteConfig request) throws Exception {
        request.setSort_id(Optional.ofNullable(request.getSort_id()).orElse("config_group_id"));

        List<SiteConfig> list;
        Map<String, List<?>> result = new HashMap<>();
        int pagingNum;
        try {
            list = selectGroupPage(request);
            pagingNum = selectGroupPagingTotalNumber(request);

            List<Integer> pagingList = new ArrayList<>();
            pagingList.add(pagingNum);

            result.put("DATA", list);
            result.put("TOTAL_PAGING", pagingList);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }

    protected List<SiteConfig> selectGroupPage(SiteConfig request) throws Exception {
        return siteConfigMapper.SELECT_GROUP_PAGE(request);
    }

    protected int selectGroupPagingTotalNumber(SiteConfig request) throws Exception {
        return siteConfigMapper.SELECT_GROUP_PAGING_TOTAL_NUMBER(request);
    }

    public String[] findGroup() throws Exception {
        return siteConfigMapper.SELECT_GROUP();
    }

    @Override
    protected List<SiteConfig> findImpl(SiteConfig request) throws Exception {
        return siteConfigMapper.SELECT(request);
    }

    public Map<String, String> findValuesByKeys(List<String> request) throws Exception {
        return siteConfigMapper.SELECT_VALUES_BY_KEYS(request);
    }

    @Override
    protected int removeImpl(SiteConfig request) {
        return siteConfigMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(SiteConfig request) {
        return siteConfigMapper.UPDATE(request);
    }

    public int merge(SiteConfig request) {
        return siteConfigMapper.MERGE(request);
    }

    @Transactional(rollbackFor = Exception.class)
    public int merge(List<SiteConfig> request) {
        int result = 0;

        for (SiteConfig siteConfig : request) {
            result += siteConfigMapper.MERGE(siteConfig);
        }

        return result;
    }

    @Override
    protected int registerImpl(SiteConfig request) {
        return siteConfigMapper.INSERT(request);
    }

    public PasswordPolicy getPasswordPolicy() {
        return siteConfigMapper.SELECT_PASSWORD_POLICY();
    }
}