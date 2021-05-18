package com.fengye.securityspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/5/18 10:12
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //配置用户信息服务（查询用户信息）
   /* @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("zhangsan").password("$2a$10$lVKKazLSJncZ5fPYV1TjEOKHliXt7Xo.IeTuFUktEcOHoqEigCSXu").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }*/

    //密码编辑器--使用明文进行对比比较
   /* @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //配置安全拦截机制（重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  //屏蔽CSRF控制，即spring security不再限制CSRF
                .authorizeRequests()
//                .antMatchers("/r/r1").hasAuthority("p1")
//                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()  //所有/r/**的请求必须认证通过
                .anyRequest().permitAll()   //除了/r/**，其它的请求都可以访问
                .and()
                .formLogin()  //允许表单登录
                .loginPage("/login-view")  //指定我们自己的登录页面重定向跳转到/login-view
                .loginProcessingUrl("/login")
                .successForwardUrl("/login-success")  //自定义登录成功的页面地址
                //登出功能
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login‐view?logout")
//                .logoutSuccessHandler(logoutSuccessHandler)
//                .addLogoutHandler(logoutHandler)
//                .invalidateHttpSession(true)
                .permitAll();  //允许任意用户访问基于表单登录的所有的URL
    }
}
