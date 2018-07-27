package com.zhou.service;

import com.zhou.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<Menu> getParentMenu();

    List<Menu> getChildMenus();

    List<Map<String,Object>> getMenus();
}
