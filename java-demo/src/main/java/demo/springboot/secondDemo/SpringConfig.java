package demo.springboot.secondDemo;

import demo.springboot.firstDemo.other.OtherConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 2019/7/6
 * zhouchao
 */
@Configuration
@Import(OtherConfig.class)
public class SpringConfig {

    @Bean
    public DefaultBean defaultBean(){
        return new DefaultBean();
    }
}
