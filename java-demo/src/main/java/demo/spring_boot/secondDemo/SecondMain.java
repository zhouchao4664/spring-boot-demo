package demo.spring_boot.secondDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019/7/6
 * zhouchao
 */

public class SecondMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        String[] defNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < defNames.length; i++) {
            System.out.println(defNames[i]);
        }
    }
}
