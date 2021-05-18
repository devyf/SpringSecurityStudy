package com.fengye.springsecurity.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/5/18 8:21
 */
@Configuration
@ComponentScan(basePackages = "com.fengye.springsecurity.springmvc",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
}
