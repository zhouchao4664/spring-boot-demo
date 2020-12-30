package com.zhouchao.security.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.zhouchao.security.biz.AbstractLogin;
import com.zhouchao.security.biz.Login;
import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.core.exception.GlobalErrorCode;
import com.zhouchao.security.dto.AuthLogin;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author zhouchao
 * @Date 2020/12/28 14:17
 * @Description
 **/
@RestController
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
