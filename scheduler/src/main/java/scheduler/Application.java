package scheduler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhouchao
 * @Date 2020/1/22 10:49
 * @Description
 **/
@SpringBootApplication
@MapperScan("scheduler.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
