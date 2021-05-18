package com.fengye.security.springmvc.service;

import com.fengye.security.springmvc.model.AuthenticationRequest;
import com.fengye.security.springmvc.model.UserDto;

/**
 * @Description: 认证服务
 * @Author: huang
 * @Date: 2021/5/17 22:05
 */
public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求，账号密码
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
