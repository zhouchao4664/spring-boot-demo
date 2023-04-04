package com.zhouchao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.domain.TestUser;
import com.zhouchao.mapper.TestUserMapper;
import com.zhouchao.service.ITestUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouchao
 * @since 2023-02-20
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {

    @Resource
    private TestUserMapper testUserMapper;

    /**
     * @param testUser
     * @description: 修改用户
     * @author: zhouchao
     * @date: 2023/4/4 14:45
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateUser(TestUser testUser) {
        testUserMapper.insert(testUser);
    }
}
