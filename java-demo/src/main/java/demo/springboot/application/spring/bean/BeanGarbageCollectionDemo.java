package demo.springboot.application.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author zhouchao
 * @Date 2021/2/25 19:16
 * @Description Bean 垃圾回收 （GC） 示例
 **/

public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册Configuration Class (配置类)
        annotationConfigApplicationContext.register(BeanInitializationDemo.class);

        // 启动spring上下文
        annotationConfigApplicationContext.refresh();

        // 显示关闭Spring应用上下文
        annotationConfigApplicationContext.close();

        System.out.println("Spring 应用上下文已关闭...");
        Thread.sleep(5000l);
        // 强制触发 GC
        System.gc();
        Thread.sleep(5000l);
    }
}
