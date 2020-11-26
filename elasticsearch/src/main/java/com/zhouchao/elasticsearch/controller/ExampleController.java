package com.zhouchao.elasticsearch.controller;

import com.zhouchao.elasticsearch.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhouchao
 * @Date 2020/11/26 16:15
 * @Description
 **/
@RestController
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    public ExampleService exampleService;

    @GetMapping("/syn/index")
    public String synIndex(){
        exampleService.synIndex();
        return "success";
    }

}
