package com.lee.demoshiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;

public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证");
        String username = (String) authenticationToken.getPrincipal();
        String userPass = new String((char[]) authenticationToken.getCredentials());
        //假设 该用户的 注册时 密码为 123456
        String realPass = "123456";
        if (username == null) {
            throw new AccountException("用户名不正确");
        }else if (!realPass.equals(userPass)) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(username, realPass,getName());
    }
}
