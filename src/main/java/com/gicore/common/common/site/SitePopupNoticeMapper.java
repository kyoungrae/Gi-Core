package com.gicore.common.common.site;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SitePopupNoticeMapper extends CommonMapper<SitePopupNotice> {
    void INSERT_AND_RETURN_ID(@Param("notice_id") String noticeId, SitePopupNotice vo) throws Exception;
    List<Map<String, Object>> SELECT_NOTICE_WITH_TARGET_GROUP(SitePopupNotice vo);
    List<Map<String, Object>> SELECT_NOTICE_BY_USER_GROUP(SitePopupNotice vo);
}