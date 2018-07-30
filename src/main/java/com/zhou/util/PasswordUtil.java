package com.zhou.util;

import com.zhou.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
/**
 * 密码加密的工具类
 */
public class PasswordUtil {
    private SecureRandomNumberGenerator randomNumberGenerator= new SecureRandomNumberGenerator();
    public static User generate(User user) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();;
        user.setSalt(salt);
        //md5 加密的方式  2 加密的次数
        String newPassword = new SimpleHash(
                "md5",
                user.getPassword(),
                user.getSalt(),
                2).toHex();
        user.setPassword(newPassword);
        return user;
    }

}
