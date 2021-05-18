package com.fengye.securityspringboot.controller;

import com.fengye.securityspringboot.dao.UserDao;
import com.fengye.securityspringboot.model.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/5/18 8:46
 */
@RestController
public class LoginController {


    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        String username = getUsername();
        return username + " 登录成功";
    }

    /**
     * 获取当前登录用户名
     * @return
     */
    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //如果未授权
        if(!authentication.isAuthenticated()){
            return null;
        }

        Object principal = authentication.getPrincipal();
        String username = "";
        if(principal instanceof UserDto){
            username = ((UserDto) principal).getUsername();
        }
        else {
            username = principal.toString();
        }

        return username;
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        String username = getUsername();
        return username + " 访问资源1";
    }

    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(){
        String username = getUsername();
        return username + " 访问资源2";
    }
}
