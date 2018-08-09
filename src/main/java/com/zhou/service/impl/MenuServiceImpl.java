package com.zhou.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhou.dao.*;
import com.zhou.entity.*;
import com.zhou.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
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
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

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

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getMenus();
    }

    @Override
    public List<Map<String, Object>> getAllMenus1() {
        List<Map<String, Object>>  list = menuMapper.getMenus1();
        return list;
    }

    @Override
    public int getcount() {
        return menuMapper.getcount();
    }

    @Override
    public JSONObject addChildMenu(Menu menu) {
        JSONObject jsonObject = new JSONObject();
        try{
            String id = menu.getId();
            id = id==null||"".equals(id)?UUID.randomUUID().toString().replaceAll("-",""):id;
            menu.setId(id);
            menuMapper.addMenu(menu);
            jsonObject.put("code",1);
            jsonObject.put("msg","新增菜单成功");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code",0);
            jsonObject.put("msg","新增菜单失败请联系管理员!");
        }
        return jsonObject;
    }

    @Override
    public JSONObject addParentMenu(Menu menu) {
        JSONObject jsonObject = new JSONObject();

        try {
            //将菜单存入到menu表中
            String id = menu.getId();
            id = id == null || "".equals(id) ? UUID.randomUUID().toString().replaceAll("-",""): id;
            menu.setId(id);
            menuMapper.addMenu(menu);

            //新建权限
            Permission permission = new Permission();
            String id2 = UUID.randomUUID().toString().replaceAll("-","");
            permission.setId(id2);
            permission.setPermission("normal:*");
            permission.setDescription(menu.getName());
            permission.setAvailable("1");
            permission.setPid(id);
            permissionMapper.addPermission(permission);

            //给普通人员加上改权限
            RolePermission rolePermission = new RolePermission();
            String id3 = UUID.randomUUID().toString().replaceAll("-","");
            rolePermission.setId(id3);
            rolePermission.setRoleid("2");
            rolePermission.setPermissionid(id2);
            rolePermissionMapper.addRolePermission(rolePermission);

            //给超级管理员也加上权限
            String id4 = UUID.randomUUID().toString().replaceAll("-","");
            rolePermission.setId(id4);
            rolePermission.setRoleid("1");
            rolePermissionMapper.addRolePermission(rolePermission);

            jsonObject.put("code",1);
            jsonObject.put("msg","新增菜单成功");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code",0);
            jsonObject.put("msg","新增菜单失败请联系管理员!");
        }
        return jsonObject;

    }
}
