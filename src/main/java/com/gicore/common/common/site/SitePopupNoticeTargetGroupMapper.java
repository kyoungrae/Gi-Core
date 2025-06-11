package com.gicore.common.common.site;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SitePopupNoticeTargetGroupMapper extends CommonMapper<SitePopupNoticeTargetGroup> {
    int INSERT_ALL(List<SitePopupNoticeTargetGroup> targetGroups) throws Exception;
    List<SitePopupNoticeTargetGroup> SELECT_WITH_COMMON_GROUP(SitePopupNoticeTargetGroup vo) throws Exception;
}