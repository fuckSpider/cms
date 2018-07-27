package com.zhou.dao;

import com.zhou.entity.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {
    List<Permission> findPermissionByRoleid(String roleid);
}
