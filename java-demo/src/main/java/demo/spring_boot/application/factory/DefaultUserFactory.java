package demo.spring_boot.application.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Author zhouchao
 * @Date 2021/2/18 16:51
 * @Description
 **/

public class DefaultUserFactory implements UserFactory , InitializingBean {

    // 1.基于 @PostConstruct 注解
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct ：UserFactory 初始化中");
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory()：UserFactory 初始化中");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet()：UserFactory 初始化中");
    }
}
