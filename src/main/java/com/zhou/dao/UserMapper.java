package com.zhou.dao;

import com.zhou.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findById(String id);
    User findByUsername(String username);

    int saveUser(User user);
}
