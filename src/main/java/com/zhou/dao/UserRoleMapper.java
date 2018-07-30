package com.zhou.dao;

import com.zhou.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    int saveUserRole(UserRole userRole);
}
