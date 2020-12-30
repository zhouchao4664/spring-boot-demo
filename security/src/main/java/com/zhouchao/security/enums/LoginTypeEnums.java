package com.zhouchao.security.enums;

/**
 * @Author zhouchao
 * @Date 2020/12/30 11:23
 * @Description
 **/
public enum LoginTypeEnums {
    NORMAL(0, "账号密码登录"),
    PHONE_PWD(1, "手机号密码登录"),
    PHONE_CODE(2, "手机验证码登录"),
    WECHAT(3, "微信授权登录")
    ;

    private int code;
    private String des;

    LoginTypeEnums(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
