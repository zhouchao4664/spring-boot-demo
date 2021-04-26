package com.zhouchao;

import com.zhouchao.config.datasource.DataSourceProperties;
import com.zhouchao.config.datasource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @Author zhouchao
 * @Date 2021/4/22 15:30
 * @Description
 **/
@MapperScan("com.zhouchao.dao")
@SpringBootApplication
@EnableConfigurationProperties(DataSourceProperties.class)
@Import({DynamicDataSourceRegister.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

