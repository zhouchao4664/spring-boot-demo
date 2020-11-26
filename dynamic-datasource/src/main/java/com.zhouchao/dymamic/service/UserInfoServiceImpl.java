package com.zhouchao.dymamic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.dymamic.domain.UserInfo;
import com.zhouchao.dymamic.repository.ds2.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouchao
 * @since 2020-11-25
 */
@Service
@DS("ds2")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> {

}
