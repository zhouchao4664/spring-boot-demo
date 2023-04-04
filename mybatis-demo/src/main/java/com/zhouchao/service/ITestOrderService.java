package com.zhouchao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhouchao.domain.TestOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouchao
 * @since 2023-04-04
 */
public interface ITestOrderService extends IService<TestOrder> {

    void saveOrder(TestOrder testOrder);

}
