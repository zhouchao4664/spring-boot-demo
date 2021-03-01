package demo.spring_boot.application.spring.bean;

import demo.spring_boot.application.spring.bean.factory.DefaultUserFactory;
import demo.spring_boot.application.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


/**
 * @Author zhouchao
 * @Date 2021/2/18 18:55
 * @Description Bean初始化
 **/
@Configuration
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();


        // 创建一个外部UserFactory对象
        UserFactory userFactory = new DefaultUserFactory();
        SingletonBeanRegistry singletonBeanRegistry = annotationConfigApplicationContext.getBeanFactory();

        // 注册外部单例对象
        singletonBeanRegistry.registerSingleton("userFactory", userFactory);

        // 启动spring上下文
        annotationConfigApplicationContext.refresh();

        // 通过依赖查找的方式来获取UserFactory
        UserFactory userFactoryByLookup = annotationConfigApplicationContext.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == userFactoryBylookup : " + (userFactory == userFactoryByLookup));

        // 显示关闭Spring应用上下文
        annotationConfigApplicationContext.close();

    }
}
