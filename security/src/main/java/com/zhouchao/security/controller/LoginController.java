package com.zhouchao.security.controller;

import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.core.exception.GlobalErrorCode;
import com.zhouchao.security.dto.AuthLogin;
import com.zhouchao.security.login.AbstractLogin;
import com.zhouchao.security.login.Login;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhouchao
 * @Date 2021/1/5 15:44
 * @Description
 **/
@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public ResultVo<Object> login(@RequestBody @Validated AuthLogin authLogin, BindingResult bindingResult) {
        //验证
        authLogin.validData(bindingResult);

        Login login = AbstractLogin.loginMap.get(authLogin.getLoginType());
        if (login == null) {
            return ResultVo.failure(GlobalErrorCode.LOGIN_TYPE_ERROR.getCode(), GlobalErrorCode.LOGIN_TYPE_ERROR.getMessage(), null);
        }
        return login.doLogin(authLogin);
    }


}
