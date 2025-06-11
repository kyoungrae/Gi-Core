package com.gicore.common.common.site;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SiteSentMailManagementMapper extends CommonMapper<SiteSentMailManagement> {
    int UPDATE_BY_RESULT(List<SiteSentMailManagement> logList) throws Exception;
    List<SiteSentMailManagement> SELECT_WITH_MAIL_AND_USER(SiteSentMailManagement request) throws Exception;
    int INSERT_ALL(List<SiteSentMailManagement> logList) throws Exception;

}