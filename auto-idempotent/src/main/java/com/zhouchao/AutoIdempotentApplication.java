package com.zhouchao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author zhouchao
 * @Date 2020/6/11 15:05
 * @Description
 **/
@SpringBootApplication
@EnableAspectJAutoProxy
public class AutoIdempotentApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoIdempotentApplication.class, args);
    }
}
