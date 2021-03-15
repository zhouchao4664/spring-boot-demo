package demo.springboot.application.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2021/2/1 16:02
 * @Description
 **/
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("周超");
        user.setAge(32);
        user.setAddress("北京");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象： " + users);
        }
    }

}
