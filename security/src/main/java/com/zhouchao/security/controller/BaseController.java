package com.zhouchao.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zhouchao
 * @Date 2020/11/3 16:30
 * @Description
 **/
@Controller
public class BaseController {

    @GetMapping("/login.html")
    public String loginPage(){
        return "/login.html";
    }

    @GetMapping("/home.html")
    public String home(){
        return "/home.html";
    }

    @GetMapping("/")
    public String basePage(){
        return "/home.html";
    }

    @GetMapping("/error")
    public String errorPage(){
        return "/error.html";
    }
}
