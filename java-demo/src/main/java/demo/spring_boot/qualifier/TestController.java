package demo.spring_boot.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * 2020/9/26
 * zhouchao
 */
@RestController
public class TestController {

    @Autowired
    List<TestDemo> testDemoList = Collections.emptyList();

    @GetMapping("test")
    public Object test(){
        return testDemoList;
    }

}
