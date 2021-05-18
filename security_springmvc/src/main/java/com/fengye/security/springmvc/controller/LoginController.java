package com.fengye.security.springmvc.controller;

import com.fengye.security.springmvc.model.AuthenticationRequest;
import com.fengye.security.springmvc.model.UserDto;
import com.fengye.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description:  用户登录请求
 * @Author: huang
 * @Date: 2021/5/17 22:21
 */
@RestController
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    /**
     * 用户登录
     * @param authenticationRequest  登录请求
     * @param session  http会话
     * @return
     */
    //text/plain文本形式
    @RequestMapping(value = "/login", produces = "text/plain;charset=UTF-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        //登录成功，用户信息存入session
        session.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        return userDto.getFullname() + "登录成功";
    }

    @GetMapping(value = "/logout", produces = "text/plain;charset=UTF-8")
    public String logout(HttpSession session){
        session.invalidate();  //登出之后，让session失效
        return "登出成功";
    }

    /**
     * 测试资源1
     * @param session
     * @return
     */
    @GetMapping(value = "/r/r1",produces = "text/plain;charset=UTF-8")
    public String r1(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问资源1";
    }

    /**
     * 测试资源2
     * @param session
     * @return
     */
    @GetMapping(value = "/r/r2",produces = "text/plain;charset=UTF-8")
    public String r2(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问资源2";
    }
}
