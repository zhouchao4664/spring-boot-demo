package com.zhouchao.dymamic.controller;


import com.zhouchao.dymamic.domain.OrderMaster;
import com.zhouchao.dymamic.service.OrderMasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouchao
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/order-master")
public class OrderMasterController {

    @Autowired
    private OrderMasterServiceImpl orderMasterService;

    @PostMapping("/add")
    public String addUserInfo(@RequestBody OrderMaster orderMaster){
        orderMasterService.save(orderMaster);
        return "success";
    }
}
