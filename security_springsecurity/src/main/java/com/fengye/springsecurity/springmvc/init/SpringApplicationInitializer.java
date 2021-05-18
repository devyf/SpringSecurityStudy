package com.fengye.springsecurity.springmvc.init;

import com.fengye.springsecurity.springmvc.config.ApplicationConfig;
import com.fengye.springsecurity.springmvc.config.WebConfig;
import com.fengye.springsecurity.springmvc.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/5/18 8:27
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //加载applicationContext.xml与security配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { ApplicationConfig.class, WebSecurityConfig.class};//指定rootContext的配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class }; //指定servletContext的配置类
    }

    //url-mapping
    @Override
    protected String[] getServletMappings() {
        return new String [] {"/"};
    }


}
