package demo.springboot.configDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhouchao
 * @Date 2021/3/9 11:09
 * @Description
 **/
@RestController
public class ConfigController {

    // demo1
    @Value("${pname}")
    private String projectName;

    @GetMapping("pname")
    public String test() {
        return projectName;
    }

    // demo2
    @Value("${java.version}")
    private String version;

    @GetMapping("version")
    public String version() {
        return version;
    }

    // demo3
    @Value("${test.random}")
    private Integer random;

    @GetMapping("random")
    public Integer getRandom(){
        return random;
    }

    // 测试自定义json配置
    @Value("${custom.property.hello}")
    private String name;

    @GetMapping("/config")
    public String config(){
        return name;
    }
}
