package com.zhouchao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.domain.TestOrder;
import com.zhouchao.mapper.TestOrderMapper;
import com.zhouchao.service.ITestOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouchao
 * @since 2023-04-04
 */
@Service
public class TestOrderServiceImpl extends ServiceImpl<TestOrderMapper, TestOrder> implements ITestOrderService {

    @Resource
    private TestOrderMapper testOrderMapper;


    @Override
    public void saveOrder(TestOrder testOrder) {
        testOrderMapper.insert(testOrder);
    }

}
