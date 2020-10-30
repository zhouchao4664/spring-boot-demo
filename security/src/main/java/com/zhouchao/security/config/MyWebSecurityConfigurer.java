package com.zhouchao.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author zhouchao
 * @Date 2020/10/22 18:29
 * @Description
 **/
@Configuration
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhouchao")
                .password("{noop}123") //{noop}表示不加密
                .authorities("ADMIN");
    }

}
