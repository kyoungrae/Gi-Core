package com.gicore.common.common.menu;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonAccessGroupMenuListMapper extends CommonMapper<CommonAccessGroupMenuList> {

    int DELETE_ALL(CommonAccessGroupMenuList request);

}