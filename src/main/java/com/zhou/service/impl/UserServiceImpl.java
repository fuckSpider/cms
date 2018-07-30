package com.zhou.service.impl;

import com.zhou.dao.PermissionMapper;
import com.zhou.dao.RoleMapper;
import com.zhou.dao.UserMapper;
import com.zhou.dao.UserRoleMapper;
import com.zhou.entity.Permission;
import com.zhou.entity.Role;
import com.zhou.entity.User;
import com.zhou.entity.UserRole;
import com.zhou.service.UserService;
import com.zhou.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


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

    @Override
    public int saveUser(User user) {
        //密码加盐加密
        user = PasswordUtil.generate(user);
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        user.setId(uuid);
        user.setLocked(0);
        user.setCreatetime(LocalDate.now().toString());
        //保存到user表中
        int count = userMapper.saveUser(user);
        //保存userRole
        UserRole userRole = new UserRole();
        String uuid2 = UUID.randomUUID().toString().replaceAll("-","");
        userRole.setId(uuid2);
        userRole.setUserid(user.getId());
        userRole.setRoleid("2");
        userRoleMapper.saveUserRole(userRole);
        return count;
    }

}
