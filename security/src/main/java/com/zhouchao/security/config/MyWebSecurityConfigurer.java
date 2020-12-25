package com.zhouchao.security.config;

import com.zhouchao.security.jwt.JwtAuthentication;
import com.zhouchao.security.jwt.JwtFilter;
import com.zhouchao.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/10/22 18:29
 * @Description
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtAuthentication jwtAuthentication;

    @Autowired
    private JwtFilter jwtFilter;

    @Value("${jwt.path}")
    private String loginPath;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("zhouchao")
                .password("{noop}123") //{noop}表示不加密
                .authorities("ADMIN");*/

        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login.html", "/error.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login.do")
                .defaultSuccessUrl("/home.html")
                .failureForwardUrl("/error.html")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html")
                .and().rememberMe()
                .and().csrf().disable()
                .httpBasic();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {

        int i = 1000_0000;
        System.out.println(i);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123"));
        System.out.println(encoder.encode("123"));
        System.out.println(encoder.encode("123"));

        String pwd1 = encoder.encode("123");
        String pwd2 = encoder.encode("123");

        System.out.println(encoder.matches("123", pwd1));
        System.out.println(encoder.matches("123", pwd2));

    }

}
