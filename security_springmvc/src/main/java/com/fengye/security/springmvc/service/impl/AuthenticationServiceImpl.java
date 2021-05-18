package com.fengye.security.springmvc.service.impl;

import com.fengye.security.springmvc.model.AuthenticationRequest;
import com.fengye.security.springmvc.model.UserDto;
import com.fengye.security.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 根据用户名查找用户信息，并校验密码
 * @Author: huang
 * @Date: 2021/5/17 22:10
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest == null || StringUtils.isEmpty(authenticationRequest.getUsername())
            || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("用户名或密码为空");
        }

        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if(userDto == null){
            throw new RuntimeException("查询不到该用户");
        }
        if(!authenticationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("账号密码错误");
        }
        return userDto;
    }

    public UserDto getUserDto(String username){
        return userMap.get(username);
    }

    //伪数据用户：模拟两个用户信息
    private Map<String,UserDto> userMap = new HashMap<>();
    {
        Set<String> authorties1 = new HashSet<>();
        Set<String> authorties2 = new HashSet<>();
        authorties1.add("p1");
        authorties2.add("p2");
        userMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","133443", authorties1));
        userMap.put("lisi",new UserDto("1011","lisi","456","李四","144553", authorties2));
    }
}
