package com.zhouchao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.dao.ScoreMapper;
import com.zhouchao.domain.Score;
import com.zhouchao.handler.com.zhouchao.handler.PlatformHandler;
import com.zhouchao.properties.KeywordConfigProperties;
import com.zhouchao.service.IScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouchao
 * @since 2021-06-15
 */
@Slf4j
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

    @Autowired
    private KeywordConfigProperties keywordConfigProperties;

    @Autowired
    private List<PlatformHandler> platformHandlerList;

    @Override
    public String crawl() {
        List<Score> scoreList = new ArrayList<>();

        keywordConfigProperties.getList().forEach(s -> {
            log.info(s);
            platformHandlerList.forEach(platformHandler -> {
                scoreList.addAll(platformHandler.crawl(s));
            });
        });

        return "success";
    }
}
