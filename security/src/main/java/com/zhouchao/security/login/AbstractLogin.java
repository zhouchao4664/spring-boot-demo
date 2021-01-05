package com.zhouchao.security.login;

import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.core.exception.ValidException;
import com.zhouchao.security.domain.SysUser;
import com.zhouchao.security.dto.AuthLogin;
import com.zhouchao.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
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
        SysUser user = doProcessor(authLogin);
        Map<String, Object> payload = new HashMap<>();
        payload.put("userid", user.getId());
        payload.put("username", user.getName());
        String token = JwtUtils.generatorToken(payload);
        return ResultVo.success(token);
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
     * @return
     */
    public abstract SysUser doProcessor(AuthLogin authLogin);
}
