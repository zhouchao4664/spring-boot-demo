package demo.springboot.configDemo.config;

import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2020/9/10 22:27
 * @Description
 **/

public class MyDefineJsonProperySource extends EnumerablePropertySource<Map<String,Object>> {

    public MyDefineJsonProperySource(String name, Map<String, Object> source) {
        super(name, source);
    }

    @Override
    public String[] getPropertyNames() {
        return StringUtils.toStringArray(this.source.keySet());
    }

    @Override
    public Object getProperty(String name) {
        return this.source.get(name);
    }
}
