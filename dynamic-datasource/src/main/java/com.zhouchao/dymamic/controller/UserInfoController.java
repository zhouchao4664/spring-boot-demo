package com.zhouchao.dymamic.controller;


import com.zhouchao.dymamic.domain.UserInfo;
import com.zhouchao.dymamic.service.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouchao
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @PostMapping("/add")
    public String addUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.save(userInfo);
        return "success";
    }
}
