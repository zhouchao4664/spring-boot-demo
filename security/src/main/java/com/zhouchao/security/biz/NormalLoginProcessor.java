package com.zhouchao.security.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhouchao.security.core.exception.AuthException;
import com.zhouchao.security.core.exception.GlobalErrorCode;
import com.zhouchao.security.core.exception.ValidException;
import com.zhouchao.security.dao.SysUserMapper;
import com.zhouchao.security.domain.SysUser;
import com.zhouchao.security.dto.AuthLogin;
import com.zhouchao.security.enums.LoginTypeEnums;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.xml.bind.ValidationException;

/**
 * @Author zhouchao
 * @Date 2020/12/30 14:14
 * @Description
 **/
@Slf4j
@Service
public class NormalLoginProcessor extends AbstractLogin {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int getLoginType() {
        return LoginTypeEnums.NORMAL.getCode();
    }

    @Override
    public void validate(AuthLogin authLogin) throws ValidException {
        if (StringUtils.isBlank(authLogin.getUsername()) || StringUtils.isBlank(authLogin.getPassword())) {
            throw new ValidException(GlobalErrorCode.ACCOUNT_EMPTY);
        }
    }

    @Override
    public void doProcessor(AuthLogin authLogin) {
        log.info("begin NormalLoginProcesser.doProcessor:" + authLogin);
        SysUser user = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getName, authLogin.getUsername()));
        if (user == null) {
            throw new AuthException(GlobalErrorCode.USER_NOT_EXIST);
        }

        if (!DigestUtils.md5DigestAsHex(authLogin.getPassword().getBytes()).equals(user.getPwd())) {
            throw new AuthException(GlobalErrorCode.ACCOUNT_DISABLED);
        }
    }
}
