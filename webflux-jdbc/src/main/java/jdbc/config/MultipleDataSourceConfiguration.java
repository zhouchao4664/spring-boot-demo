package jdbc.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 2020/1/1
 * zhouchao
 */
@Configuration
public class MultipleDataSourceConfiguration {
//    spring.datasource.driverClassName = com.mysql.jdbc.Driver
//    spring.datasource.url = jdbc:mysql://localhost:3306/spring-test
//    spring.datasource.username = root
//    spring.datasource.password = zhc4664

    @Bean
    @Primary
    public DataSource masterDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        DataSource dataSource = dataSourceBuilder
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/spring-test")
                .username("root")
                .password("zhc4664")
                .build();
        return dataSource;
    }

    @Bean
    public DataSource slaveDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        DataSource dataSource = dataSourceBuilder
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/spring-test")
                .username("root")
                .password("zhc4664")
                .build();
        return dataSource;
    }

}
