package com.fengye.security.springmvc.interceptor;

import com.fengye.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/5/17 23:32
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //读取会话信息
        Object obj = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if(obj == null){
            writeContent(response,"请登录！");
            return false;
        }
        //如果登录了，根据用户的登录信息和url进行授权验证
        UserDto userDto = (UserDto) obj;
        String requestURI = request.getRequestURI();
        if(userDto.getAuthorities().contains("p1") && requestURI.contains("/r/r1")){
            return true;
        }
        if(userDto.getAuthorities().contains("p2") && requestURI.contains("/r/r2")){
            return true;
        }
        writeContent(response, "权限不足，拒绝访问！");
        return false;
    }

    public void writeContent(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(message);
        response.getWriter().close();
    }
}
