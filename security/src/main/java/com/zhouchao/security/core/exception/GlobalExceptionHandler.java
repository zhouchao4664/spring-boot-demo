/**
 * Project Name:saas-access
 * File Name:GlobalExceptionHandler.java
 * Package Name:com.ccop.access.core.exception
 * Date:2017年9月20日上午11:00:14
 * Copyright (c) 2017, WangLZ All Rights Reserved.
 */

package com.zhouchao.security.core.exception;


import com.zhouchao.security.core.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:全局异常处理 <br/>
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.info("GlobalExceptionHandler.handleException:{}", request.getRequestURI());
        String msg = "系统繁忙：" + ex.getMessage();
        if (ex instanceof ValidException || ex instanceof BizException || ex instanceof AuthException) {
            handleStackTraceElement(ex);
            msg = ex.getMessage();
        }
        return ResultVo.failure(GlobalErrorCode.SYSTEM_ERROR.getCode(), msg, null);
    }

    private void handleStackTraceElement(Exception ex) {
        StackTraceElement[] ste = ex.getStackTrace();
        if (ste != null) {
            StackTraceElement cause = ste[0];
            log.info("Exception Location [ClassName: " + cause.getClassName() + ", MethodName: "
                    + cause.getMethodName() + ", LineNumber: " + cause.getLineNumber() + "]");
        }
    }
}
