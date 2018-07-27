package com.zhou.service;

import com.zhou.entity.Permission;
import com.zhou.entity.Role;
import com.zhou.entity.User;

import java.util.List;

public interface UserService {
    User findById(String id);
    User findByUsername(String username);

    List<Permission> findPermissionByUserid(String userid);
    List<Role> findRoleByUserid(String userid);
}
