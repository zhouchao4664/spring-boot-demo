package com.zhouchao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.domain.TestUser;
import com.zhouchao.mapper.TestUserMapper;
import com.zhouchao.service.ITestUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouchao
 * @since 2023-02-20
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {

}
