package demo.spring_boot.application;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhouchao
 * @Date 2021/2/18 11:25
 * @Description
 **/

public class BeanAliasDemo {
    public static void main(String[] args) {
        //获取Bean工厂
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-definition-context.xml");

        User user = beanFactory.getBean("user",User.class);
        User zhouchao_user = beanFactory.getBean("zhouchao-user",User.class);

        System.out.println("zhouchao-user 是否与 user Bean 相同:"+ (user == zhouchao_user));
    }
}
