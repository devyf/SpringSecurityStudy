package com.fengye.security.springmvc.model;

import lombok.Data;

/**
 * @Description: 用户认证请求字段
 * @Author: huang
 * @Date: 2021/5/17 22:06
 */
@Data
public class AuthenticationRequest {
    //认证请求参数：账号、密码
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
