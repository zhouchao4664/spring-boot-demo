package com.zhouchao.handler.com.zhouchao.handler;

import com.zhouchao.domain.Score;

import java.util.List;

/**
 * @Author: zhouchao
 * @Date: 2021/06/15 14:02
 * @Description:
 */
public interface PlatformHandler {
    List<Score> crawl(String keyword);
}
