package com.gicore.common.common.menu;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends CommonMapper<Menu> {
    List<Menu> SELECT_HIERARCHY(Menu request);
    List<Menu> SELECT_HIERARCHY_WITH_ACCESS_RIGHT_GROUP(Menu request);
    List<Menu> SELECT_JOIN_COMMON_ACCESS_GROUP_MENU_LIST(Menu request);
}
