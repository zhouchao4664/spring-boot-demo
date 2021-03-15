package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ca = SpringApplication.run(DemoApplication.class, args);

		String[] beanDefs = ca.getBeanDefinitionNames();
		for (String beanDef:beanDefs) {
			System.out.println(beanDef);
		}
	}

}
