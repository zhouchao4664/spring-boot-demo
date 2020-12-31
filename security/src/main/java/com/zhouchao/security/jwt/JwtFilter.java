package com.zhouchao.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/12/30 17:25
 * @Description
 **/
@Slf4j
@Component
public class JwtFilter extends UsernamePasswordAuthenticationFilter {

    @Value("#{'${jwt.path}'.split(',')}")
    private List<String> ignoreUrls;




}
