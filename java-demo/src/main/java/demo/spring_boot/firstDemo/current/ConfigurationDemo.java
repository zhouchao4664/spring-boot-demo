package demo.spring_boot.firstDemo.current;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2019/7/6
 * zhouchao
 */
@Configuration
public class ConfigurationDemo {

    @Bean
    public DemoClass demoClass(){
        return new DemoClass();
    }

}
