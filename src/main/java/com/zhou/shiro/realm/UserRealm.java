package com.zhou.shiro.realm;

import com.zhou.entity.Permission;
import com.zhou.entity.Role;
import com.zhou.entity.User;
import com.zhou.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 用户登录授权功能
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findByUsername(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(user!=null){
            List<Role> roles = userService.findRoleByUserid(user.getId());
            for(Role role:roles){
                info.addRole(role.getRole());
            }
            //根据用户id获取权限列表
            List<Permission> permissions = userService.findPermissionByUserid(user.getId());
            for(Permission permission:permissions){
                info.addStringPermission(permission.getPermission());
            }
            return info;
        }
        return null;
    }


    /**
     * 用户登录认证过程
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取到输入的用户名
        UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) authenticationToken;
        String username = (String) usernamePasswordToken.getPrincipal();

        User user =userService.findByUsername(username);
        ByteSource credentialsSalt =ByteSource.Util.bytes(user.getSalt());
        if(user==null){
            throw new UnknownAccountException();
        }
        if(user.getLocked()==1){
            throw new LockedAccountException(); //帐号锁定
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),credentialsSalt,getName());
        return authenticationInfo;
    }
}
