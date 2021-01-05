package com.zhouchao.security.core.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.core.exception.GlobalErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhouchao
 * @Date 2021/1/4 17:13
 * @Description 用户登录失败时返回的数据
 **/
@Component
@Slf4j
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String result = new ObjectMapper().writeValueAsString(ResultVo.failure(GlobalErrorCode.AUTH_ERROR, null));
        log.info(result);
        response.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
        response.setHeader("Content-Type", "text/html;charset=utf-8");  //设置响应头的编码
        response.getWriter().write(result);
    }
}
