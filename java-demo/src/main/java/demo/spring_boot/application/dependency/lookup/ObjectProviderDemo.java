package demo.spring_boot.application.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author zhouchao
 * @Date 2021/2/26 16:48
 * @Description 通过 {@link org.springframework.beans.factory.ObjectProvider} 进行依赖查找
 **/

public class ObjectProviderDemo { //@Configuration 是非必须的注解

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册Configuration Class (配置类)
        annotationConfigApplicationContext.register(ObjectProviderDemo.class);
        // 启动spring上下文
        annotationConfigApplicationContext.refresh();

        // 依赖查找集合对象
        lookupByObjectProvider(annotationConfigApplicationContext);

        // 显示关闭Spring应用上下文
        annotationConfigApplicationContext.close();
    }

    @Bean
    public String helloWorld() {
        return "Hello,World";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        ObjectProvider<String> objectProvider = annotationConfigApplicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

}
