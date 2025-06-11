package com.gicore.common.common.site;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface SiteScheduledMailMapper extends CommonMapper<SiteScheduledMail> {
    @Options(useGeneratedKeys = true, keyProperty = "vo.mail_id")
    void INSERT_AND_RETURN_ID(SiteScheduledMail vo) throws Exception;

}