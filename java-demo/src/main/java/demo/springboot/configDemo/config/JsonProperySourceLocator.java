package demo.springboot.configDemo.config;


import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2020/9/10 22:28
 * @Description
 **/

public class JsonProperySourceLocator implements PropertySourceLocator {

    private final static String DEFAULT_LOCATION = "classpath:zhouchao.json";

    private final ResourceLoader resourceLoader = new DefaultResourceLoader(getClass().getClassLoader());

    @Override
    public PropertySource<?> locate(Environment environment) {
        MyDefineJsonProperySource jsonProperySource =
                new MyDefineJsonProperySource("jsonProperySource", mapPropertySource());

        return jsonProperySource;
    }

    private Map<String, Object> mapPropertySource() {
        Resource resource = this.resourceLoader.getResource(DEFAULT_LOCATION);
        if (resource == null) {
            return null;
        }

        Map<String, Object> result = new HashMap<>();
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> fileMap = jsonParser.parseMap(readFile(resource));
        processorMap("", result, fileMap);
        return result;
    }

    private void processorMap(String prefix, Map<String, Object> result, Map<String, Object> fileMap) {
        if (prefix.length() > 0) {
            prefix += ".";
        }
        for (Map.Entry<String, Object> entrySet : fileMap.entrySet()) {
            if (entrySet.getValue() instanceof Map) {
                processorMap(prefix + entrySet.getKey(), result, (Map<String, Object>) entrySet.getValue());
            } else {
                result.put(prefix + entrySet.getKey(), entrySet.getValue());
            }
        }
    }

    private String readFile(Resource resource) {
        FileInputStream fileInputStream = null;
        String result = null;
        try {
            fileInputStream = new FileInputStream(resource.getFile());
            byte[] readByte = new byte[(int) resource.getFile().length()]; //TODO 文件长度如果超出int大小会报错
            fileInputStream.read(readByte);
            result = new String(readByte, "UTF-8");
        } catch (Exception e) {

        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
