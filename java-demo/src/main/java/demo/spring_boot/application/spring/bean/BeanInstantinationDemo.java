package demo.spring_boot.application.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhouchao
 * @Date 2021/2/18 16:43
 * @Description Bean 实例化
 **/

public class BeanInstantinationDemo {

    public static void main(String[] args) {
        //获取Bean工厂
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantination-context.xml");

        User userByStaticMethod = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);

        System.out.println(userByStaticMethod);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);
        System.out.println(userByStaticMethod == userByInstanceMethod);
        System.out.println(userByStaticMethod == userByFactoryBean);
    }
}
