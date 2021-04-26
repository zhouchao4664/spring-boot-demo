package com.zhouchao.controller;


import com.zhouchao.config.aop.DynamicSource;
import com.zhouchao.domain.TbSource;
import com.zhouchao.service.TbSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhouchao
 * @since 2021-04-25
 */
@RestController
@RequestMapping("/source/")
public class TbSourceController {

    @Autowired
    private TbSourceService tbSourceService;

    @DynamicSource
    @GetMapping("list")
    public List<TbSource> getTbSource() {
        List<TbSource> list = tbSourceService.getTbSource();
        list.stream().forEach(System.out::println);
        return list;
    }

}
