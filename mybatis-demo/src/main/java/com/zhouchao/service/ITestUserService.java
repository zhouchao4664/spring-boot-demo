package com.zhouchao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhouchao.domain.TestUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouchao
 * @since 2023-02-20
 */
public interface ITestUserService extends IService<TestUser> {

    /**
     * @param testUser
     * @description: 修改用户
     * @author: zhouchao
     * @date: 2023/4/4 14:45
     */
    void updateUser(TestUser testUser);

}
