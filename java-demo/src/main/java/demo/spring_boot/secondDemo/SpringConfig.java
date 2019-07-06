package demo.spring_boot.secondDemo;

import demo.spring_boot.firstDemo.current.ConfigurationDemo;
import demo.spring_boot.firstDemo.other.OtherBean;
import demo.spring_boot.firstDemo.other.OtherConfig;
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
