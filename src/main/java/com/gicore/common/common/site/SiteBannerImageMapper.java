package com.gicore.common.common.site;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SiteBannerImageMapper extends CommonMapper<SiteBannerImage> {
    List<Map<String, Object>> SELECT_WITH_FILE(SiteBannerImage siteBannerImage);

    int SHIFT(int bannerImageNumber);

    int REORDER(List<SiteBannerImage> list);
}