package com.zhou.service;

import com.alibaba.fastjson.JSONObject;
import com.zhou.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<Menu> getParentMenu();

    List<Menu> getChildMenus();

    List<Map<String,Object>> getMenus();

    List<Menu> getAllMenus();

    List<Map<String,Object>> getAllMenus1();

    int getcount();

    JSONObject addChildMenu(Menu menu);

    JSONObject addParentMenu(Menu menu);

}
