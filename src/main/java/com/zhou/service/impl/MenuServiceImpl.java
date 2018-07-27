package com.zhou.service.impl;

import com.zhou.dao.MenuMapper;
import com.zhou.dao.PermissionMapper;
import com.zhou.dao.RoleMapper;
import com.zhou.dao.UserMapper;
import com.zhou.entity.Menu;
import com.zhou.entity.Permission;
import com.zhou.entity.Role;
import com.zhou.entity.User;
import com.zhou.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Menu> getParentMenu() {
        return menuMapper.getParentMenu();
    }

    @Override
    public List<Menu> getChildMenus() {
        return menuMapper.getChildMenus();
    }

    @Override
    public List<Map<String, Object>> getMenus() {
        List<Map<String, Object>> result = new ArrayList<>();
        //
        Subject subject = SecurityUtils.getSubject();
        User u = userMapper.findByUsername((String) subject.getPrincipal());
        //根据user获取权限集合
        List<Role> roles = roleMapper.getRoleByUserid(u.getId());
        List<String> pids = new ArrayList<String>();
        for(Role role:roles){
            List<Permission>permissions = permissionMapper.findPermissionByRoleid(role.getId());
            for(Permission permission :permissions){
                pids.add(permission.getPid());
            }
        }

        List<Menu> parentMenus = menuMapper.getMenuByids(pids);
        for(Menu pmenu:parentMenus){
            Map<String,Object> map = new HashMap<>();
            List<Menu> childmenus = menuMapper.getChildMenusByPid(pmenu.getId());
            map.put("parent",pmenu);
            map.put("childs",childmenus);
            result.add(map);
        }
        return result;
    }
}
