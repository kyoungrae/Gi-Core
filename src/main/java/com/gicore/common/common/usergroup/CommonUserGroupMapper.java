package com.gicore.common.common.usergroup;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonUserGroupMapper extends CommonMapper<CommonUserGroup> {
    int INSERT_OR_UPDATE(CommonUserGroup vo) throws Exception;
    List<CommonUserGroup> SELECT_BY_GROUP_ID_LIST(List<String> targetGroups) throws Exception;
}