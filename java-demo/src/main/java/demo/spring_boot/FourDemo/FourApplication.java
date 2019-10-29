package demo.spring_boot.FourDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 2019/7/15
 * zhouchao
 */
@SpringBootApplication
public class FourApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ca = SpringApplication.run(FourApplication.class);

//        System.out.println(ca.getBean(ZhouchaoCore.class).study());

    }


}
