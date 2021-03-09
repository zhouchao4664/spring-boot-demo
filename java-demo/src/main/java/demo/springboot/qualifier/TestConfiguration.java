package demo.springboot.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2020/9/26
 * zhouchao
 */
@Configuration
public class TestConfiguration {

    @Qualifier
    @Bean("testDemo1")
    public TestDemo testDemo1(){
        return new TestDemo("testDemo1");
    }

    @Qualifier
    @Bean("testDemo2")
    public TestDemo testDemo2(){
        return new TestDemo("testDemo2");
    }
}
