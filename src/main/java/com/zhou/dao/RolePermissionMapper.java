package com.zhou.dao;

import com.zhou.entity.RolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionMapper {
    int addRolePermission(RolePermission rolePermission);
}
