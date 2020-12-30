package com.zhouchao.security.dto;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

/**
 * @Author zhouchao
 * @Date 2020/12/30 11:08
 * @Description
 **/
@Data
public class AuthLogin {
    private String username;
    private String password;
    private String phone;
    private String code;
    private String openId;

    /**
     * @see com.zhouchao.security.enums.LoginTypeEnums
     */
    @NotNull(message = "登录类型不能为空")
    private Integer loginType;

    public void validData(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (ObjectError allError : bindingResult.getAllErrors()) {
                sb.append(allError.getDefaultMessage() + "\n");
            }

            throw new ValidationException(sb.toString());
        }
    }
}
