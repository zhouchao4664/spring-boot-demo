package demo.spring_boot.application;

import demo.spring_boot.application.factory.DefaultUserFactory;
import demo.spring_boot.application.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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

        // 依赖查找 UserFactory
        UserFactory userFactory = annotationConfigApplicationContext.getBean(UserFactory.class);

        // 显示关闭Spring应用上下文
        annotationConfigApplicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
