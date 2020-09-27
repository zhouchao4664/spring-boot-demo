package demo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/9/27 11:24
 * @Description
 **/

public class IntegerDemo {

    public static void main(String[] args) {
        Integer index = 1;
        List<TestClass> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            index += 1;
            TestClass testClass = new TestClass(index);
            list.add(testClass);
        }

        System.out.println(list);
    }

    @AllArgsConstructor
    @Data
    private static class TestClass {
        private Integer age;

        @Override
        public String toString() {
            return "TestClass{" +
                    "age=" + age +
                    '}';
        }
    }
}
