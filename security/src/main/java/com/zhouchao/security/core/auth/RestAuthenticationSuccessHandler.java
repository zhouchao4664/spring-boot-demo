package com.zhouchao.security.core.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.jwt.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2021/1/4 17:16
 * @Description 用户登录成功时返回的数据
 **/
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        UserDetails user = (UserDetails) authentication.getPrincipal();

        Map<String, Object> claims = new HashMap<>(3);
        claims.put(JwtUtils.USERNAME, user.getUsername());
        claims.put(JwtUtils.CREATED, new Date());
        claims.put(JwtUtils.AUTHORITIES, authentication.getAuthorities());
        String token = JwtUtils.generatorToken(claims);

        response.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
        response.setHeader("Content-Type", "text/html;charset=utf-8");  //设置响应头的编码
        response.getWriter().write(new ObjectMapper().writeValueAsString(ResultVo.success(token)));
    }
}
