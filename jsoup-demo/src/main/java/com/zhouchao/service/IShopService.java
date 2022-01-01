package com.zhouchao.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhouchao.domain.Shop;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouchao
 * @since 2022-01-01
 */
public interface IShopService extends IService<Shop> {

    void crawl(String url);
}
