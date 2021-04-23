package com.zhouchao.config.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2021/4/22 16:11
 * @Description
 **/
@Data
@Configuration //不要这个注解也可以，看着有红线不舒服
@ConfigurationProperties(prefix = "spring.datasource.dynamic")
public class DataSourceProperties {

    private Map<String, Datasource> datasource;

    @Data
    public class Datasource {
        private Boolean isDefault = false;
        private String driverClassName;
        private String url;
        private String username;
        private String password;
    }
}
