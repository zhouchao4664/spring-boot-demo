package com.zhouchao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author: zhouchao
 * @Date: 2021/06/15 11:04
 * @Description:
 */
@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("com.zhouchao.dao")
public class JsoupApplication {
    public static void main(String[] args) {
        SpringApplication.run(JsoupApplication.class, args);
    }
}
