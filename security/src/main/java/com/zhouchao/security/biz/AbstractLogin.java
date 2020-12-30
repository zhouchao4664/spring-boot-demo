package com.zhouchao.security.biz;

import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.core.exception.ValidException;
import com.zhouchao.security.dto.AuthLogin;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhouchao
 * @Date 2020/12/30 14:04
 * @Description
 **/
@Slf4j
public abstract class AbstractLogin implements Login {

    public static final ConcurrentHashMap<Integer, AbstractLogin> loginMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        loginMap.put(getLoginType(), this);
    }

    @Override
    public ResultVo<Object> doLogin(AuthLogin authLogin) throws ValidException {
        log.info("begin AbstractLogin.doLogin:" + authLogin.getUsername());
        validate(authLogin);
        doProcessor(authLogin);
        return ResultVo.success();
    }

    /**
     * 在子类中去声明自己的登录类型
     *
     * @return
     */
    public abstract int getLoginType();

    /**
     * 通过子类去王城验证
     *
     * @param authLogin
     */
    public abstract void validate(AuthLogin authLogin) throws ValidException;

    /**
     * 登录校验
     *
     * @param authLogin
     */
    public abstract void doProcessor(AuthLogin authLogin);
}
