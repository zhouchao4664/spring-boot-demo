package demo.springboot.thirdDemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 2019/7/6
 * zhouchao
 */
public class CacheImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        Map<String, Object> attributes =
                annotationMetadata.getAnnotationAttributes(EnableDefineService.class.getName());
        return new String[]{CacheService.class.getName()};
    }
}
