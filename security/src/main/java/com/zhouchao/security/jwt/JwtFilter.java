package com.zhouchao.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhouchao
 * @Date 2020/12/25 17:41
 * @Description
 **/
@Component
public class JwtFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String token = request.getHeader("Authorization");
        if (StringUtils.isNoneEmpty(token)) {
            try {
                String username = jwtUtils.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                //抛出异常 告诉当前令牌无效了
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                //抛出错误码 前端根据错误码 跳转到登录页面 去重新刷新令牌
                System.out.println("JWT Token has expired");
            }
        }

        chain.doFilter(request, response);
    }
}
