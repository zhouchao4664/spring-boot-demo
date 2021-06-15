package com.zhouchao.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhouchao.domain.Score;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouchao
 * @since 2021-06-15
 */
public interface IScoreService extends IService<Score> {
    String crawl();
}
