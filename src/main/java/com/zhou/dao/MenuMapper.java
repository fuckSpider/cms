package com.zhou.dao;

import com.zhou.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuMapper {
    List<Menu> getParentMenu();

    List<Menu> getChildMenus();

    List<Menu> getChildMenusByPid(String pid);

    List<Menu> getMenuByid(String id);

    List<Menu> getMenuByids(List<String> list);

    List<Menu> getMenus();

    List<Map<String,Object>> getMenus1();
    int getcount();
}
