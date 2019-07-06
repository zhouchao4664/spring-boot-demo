package demo.spring_boot.firstDemo.current;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019/7/6
 * zhouchao
 */
public class ConfigurationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(ConfigurationDemo.class);

        String[] defNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < defNames.length; i++) {
            System.out.println(defNames[i]);
        }

        DemoClass demoClass = applicationContext.getBean(DemoClass.class);
        demoClass.say();
    }
}
