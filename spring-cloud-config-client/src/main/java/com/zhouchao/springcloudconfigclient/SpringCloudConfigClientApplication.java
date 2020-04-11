package com.zhouchao.springcloudconfigclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        //Annotation 驱动的 Spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册监听器
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent event) {
                System.out.println(event.getSource());
            }
        });
        //发布事件
        context.refresh();
        context.publishEvent(new MyApplicationEvent(context,"Hello World"));
        //监听器得到事件

    }

    private static class MyApplicationEvent extends ApplicationEvent {

        private final ApplicationContext applicationContext;

        public MyApplicationEvent(ApplicationContext applicationContext, Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }

}
