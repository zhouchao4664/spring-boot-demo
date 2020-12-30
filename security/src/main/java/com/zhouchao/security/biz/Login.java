package com.zhouchao.security.biz;

import com.zhouchao.security.core.ResultVo;
import com.zhouchao.security.core.exception.ValidException;
import com.zhouchao.security.dto.AuthLogin;


/**
 * @Author zhouchao
 * @Date 2020/12/30 14:02
 * @Description
 **/

public interface Login {

    ResultVo<Object> doLogin(AuthLogin authLogin) throws ValidException;

}
