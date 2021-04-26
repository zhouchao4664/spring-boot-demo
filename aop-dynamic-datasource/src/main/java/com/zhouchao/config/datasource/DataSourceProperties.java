package com.zhouchao.config.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2021/4/22 16:11
 * @Description
 **/
@Data
@ConfigurationProperties(prefix = "spring.dynamic")
public class DataSourceProperties {
    private Map<String, Datasource> datasources;

    @Data
    public static class Datasource {
        /**
         * 默认数据源
         */
        private Boolean isDefault = false;

        /**
         * 驱动
         */
        private String driverClassName;

        /**
         * 数据库地址
         */
        private String url;

        /**
         * 用户名
         */
        private String username;

        /**
         * 密码
         */
        private String password;
    }
}
