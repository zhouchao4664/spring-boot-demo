package com.zhouchao.controller;

import com.zhouchao.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhouchao
 * @Date: 2022/01/01 12:39
 * @Description:
 */
@RestController
@RequestMapping("shops58")
public class Shops58Controller {

    @Autowired
    private IShopService shopService;

    @GetMapping
    public String shops58(){
        String url = "https://bj.58.com/shangpucz/pn1/";
        shopService.crawl(url);
        return "start...";
    }

}
