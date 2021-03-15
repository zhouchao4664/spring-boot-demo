package demo.springboot.firstDemo.other;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2019/7/6
 * zhouchao
 */
@Configuration
public class OtherConfig {

    @Bean
    public OtherBean otherBean(){
        return new OtherBean();
    }
}
