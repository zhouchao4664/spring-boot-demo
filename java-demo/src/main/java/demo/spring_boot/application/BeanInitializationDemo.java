package demo.spring_boot.application;

import demo.spring_boot.application.factory.DefaultUserFactory;
import demo.spring_boot.application.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


/**
 * @Author zhouchao
 * @Date 2021/2/18 18:55
 * @Description Bean初始化
 **/
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册Configuration Class (配置类)
        annotationConfigApplicationContext.register(BeanInitializationDemo.class);

        // 启动spring上下文
        annotationConfigApplicationContext.refresh();

        // 非延迟初始化再 Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 应用上下文已启动...");

        // 依赖查找 UserFactory
        UserFactory userFactory = annotationConfigApplicationContext.getBean(UserFactory.class);

        System.out.println("Spring 应用上下文准备关闭...");

        // 显示关闭Spring应用上下文
        annotationConfigApplicationContext.close();

        System.out.println("Spring 应用上下文已关闭...");
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
    @Lazy(false)
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
