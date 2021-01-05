package com.zhouchao.security.core.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.core.exception.GlobalErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhouchao
 * @Date 2021/1/4 17:04
 * @Description 无权访问返回的数据
 **/
@Component
@Slf4j
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        String result = new ObjectMapper().writeValueAsString(ResultVo.failure(GlobalErrorCode.ACCESS_DENIED, null));
        log.info(result);
        response.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
        response.setHeader("Content-Type", "text/html;charset=utf-8");  //设置响应头的编码
        response.getWriter().write(result);
    }
}
