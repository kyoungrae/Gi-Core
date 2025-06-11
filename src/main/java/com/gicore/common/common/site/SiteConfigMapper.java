package com.gicore.common.common.site;

import com.gicore.common.common.CommonMapper;
import com.gicore.common.util.passwordvalidation.PasswordPolicy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SiteConfigMapper extends CommonMapper<SiteConfig> {
    Map<String, String> SELECT_VALUES_BY_KEYS(List<String> config_keys);

    int MERGE(SiteConfig siteConfig);

    List<SiteConfig> SELECT_GROUP_PAGE(SiteConfig siteConfig);

    int SELECT_GROUP_PAGING_TOTAL_NUMBER(SiteConfig siteConfig);

    String[] SELECT_GROUP();

    PasswordPolicy SELECT_PASSWORD_POLICY();
}