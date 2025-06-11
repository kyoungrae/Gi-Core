package com.gicore.common.common.site;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SiteScheduledMailTargetGroupMapper extends CommonMapper<SiteScheduledMailTargetGroup> {
    int INSERT_ALL(List<SiteScheduledMailTargetGroup> targetGroups) throws Exception;

}