package com.zhouchao.controller;


import com.zhouchao.service.IScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouchao
 * @since 2021-06-15
 */
@Slf4j
@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private IScoreService scoreService;

    @GetMapping("crawl")
    public String crawl() {
        String result = scoreService.crawl();
        return result;
    }
}
