package demo.springboot.configDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2021/3/9 11:05
 * @Description
 **/
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        Map<String, Object> map = new HashMap<>();
        map.put("key", "value");
        springApplication.setDefaultProperties(map);

        springApplication.setAdditionalProfiles("dev", "prod");
        ConfigurableApplicationContext context = springApplication.run(args);

        for (String activeProfile : context.getEnvironment().getActiveProfiles()) {
            System.out.println(activeProfile);
        }

        System.out.println(context.getEnvironment().getProperty("key"));
    }
}
