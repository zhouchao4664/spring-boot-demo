package demo.spring_boot.thirdDemo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 2019/7/6
 * zhouchao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CacheImportSelector.class, LoggerDefinitionRegistrar.class})
public @interface EnableDefineService {
}
