package demo.spring_boot.application;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;


/**
 * @Author zhouchao
 * @Date 2021/2/18 11:45
 * @Description
 **/
// 3. 通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册Configuration Class (配置类)
        annotationConfigApplicationContext.register(Config.class);

        // 通过BeanDefinition 注册 API 方式实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(annotationConfigApplicationContext, "xiaogufeng");

        // 2.非命名 Bean 的注册方式
        registerUserBeanDefinition(annotationConfigApplicationContext);

        // 启动spring上下文
        annotationConfigApplicationContext.refresh();

        // 按类型以来查找
        System.out.println("Config 类型的所有Beans" + annotationConfigApplicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有Beans" + annotationConfigApplicationContext.getBeansOfType(User.class));

        // 显示关闭Spring应用上下文
        annotationConfigApplicationContext.close();
    }

    /**
     * 命名 Bean 的注册方式
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1l)
                .addPropertyValue("name", "小孤枫");

        // 判断如果 BeanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    // 2.通过 @Component 方式
    @Component
    public static class Config {

        // 1.通过 @Bean 方式
        @Bean({"user", "xiaogufeng-user"})
        public User user() {
            User user = new User();
            user.setId(2);
            user.setName("小孤枫");
            user.setAge(32);
            user.setAddress("北京");
            return user;
        }
    }
}
