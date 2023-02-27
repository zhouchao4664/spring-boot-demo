package com.zhouchao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.zhouchao.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

    }

}
