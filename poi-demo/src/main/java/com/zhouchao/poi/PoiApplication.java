package com.zhouchao.poi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhouchao
 * @Date 2022/5/31 17:30
 */
@SpringBootApplication
@MapperScan("com.zhouchao.poi")
public class PoiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoiApplication.class, args);
    }
}
