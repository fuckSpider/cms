package com.zhou.service.impl;

import com.zhou.dao.PermissionMapper;
import com.zhou.dao.RoleMapper;
import com.zhou.dao.UserMapper;
import com.zhou.entity.Permission;
import com.zhou.entity.Role;
import com.zhou.entity.User;
import com.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findById(String id) {
        User  u =userMapper.findById(id);
        return u;
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<Permission> findPermissionByUserid(String userid) {
        //根据userid 找到roles
        List<Role> roles = roleMapper.getRoleByUserid(userid);
        List<Permission> permissions = new ArrayList<>();
        for(Role role:roles){
            List<Permission> list = permissionMapper.findPermissionByRoleid(role.getId());
            permissions.addAll(list);
        }
        return permissions;
    }

    @Override
    public List<Role> findRoleByUserid(String userid) {
        return roleMapper.getRoleByUserid(userid);
    }


}
