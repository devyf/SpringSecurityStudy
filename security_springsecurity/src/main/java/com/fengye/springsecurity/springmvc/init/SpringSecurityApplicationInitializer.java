package com.fengye.springsecurity.springmvc.init;

import com.fengye.springsecurity.springmvc.config.WebConfig;
import com.fengye.springsecurity.springmvc.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/5/18 8:41
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitializer(){
        //如果项目中已经用了spirngmvc，需要屏蔽super方法
        //super(WebSecurityConfig.class);
    }


}
