package com.zhouchao.security.config;

import com.zhouchao.security.core.auth.*;
import com.zhouchao.security.jwt.JwtAuthenticationFilter;
import com.zhouchao.security.login.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author zhouchao
 * @Date 2020/12/28 16:27
 * @Description
 **/
@Configuration
public class MyJwtWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;

    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;

    @Autowired
    private RestLogoutSuccessHandler restLogoutSuccessHandler;

    @Value("${jwt.path}")
    private String loginPath;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(loginPath).permitAll() // 登录请求拥有所有权限
                .anyRequest().authenticated() //其余请求都要认证

                //登录的处理器
                .and().formLogin()
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .permitAll()

                //退出的处理器
                .and().logout().logoutUrl("/logout")
                .logoutSuccessHandler(restLogoutSuccessHandler)
                .permitAll()

                .and().rememberMe().userDetailsService(userDetailServiceImpl)
                .and().httpBasic().authenticationEntryPoint(restAuthenticationEntryPoint).and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 使用 JWT，关闭token
        ;

        http.exceptionHandling().accessDeniedHandler(restAccessDeniedHandler);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

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
