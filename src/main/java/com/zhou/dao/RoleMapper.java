package com.zhou.dao;

import com.zhou.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {
    List<Role> getRoleByUserid(String userid);
}
