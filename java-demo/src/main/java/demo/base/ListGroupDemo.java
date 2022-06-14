package demo.base;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zhouchao
 * @Date: 2021/06/22 12:01
 * @Description:
 */
public class ListGroupDemo {
    public static void main(String[] args) {
        java8Method();
        System.out.println("=========================");
        guavaMethod();
    }

    private static void java8Method() {
        Map<String, List<Person>> personMap = personList.stream().collect(Collectors.groupingBy(Person::getGroup));
        for (Map.Entry<String, List<Person>> entry : personMap.entrySet()) {
            entry.getValue().forEach(System.out::println);
            System.out.println("------------------------");
        }

        Map<String, Person> collect = personList.stream().collect(Collectors.toMap(Person::getName, person -> person));
        collect.forEach((k, v) -> {
            System.out.println("key:" + k + "   value:" + v.toString());
        });
    }

    private static void guavaMethod() {
        Map<String, List<Person>> personMap = Multimaps.asMap(Multimaps.index(personList, Person::getGroup));
        for (Map.Entry<String, List<Person>> entry : personMap.entrySet()) {
            entry.getValue().forEach(System.out::println);
            System.out.println("------------------------");
        }

        Map<String, Person> collect = Maps.uniqueIndex(personList, Person::getName);
        collect.forEach((k, v) -> {
            System.out.println("key:" + k + "   value:" + v.toString());
        });

    }

    private static final List<Person> personList = new ArrayList<>();

    static {
        Person person1 = new Person("关羽", 32, "蜀国");
        Person person2 = new Person("张飞", 32, "蜀国");
        Person person3 = new Person("赵云", 32, "蜀国");
        Person person4 = new Person("夏侯惇", 32, "魏国");
        Person person5 = new Person("张辽", 32, "魏国");
        Person person6 = new Person("许褚", 32, "魏国");
        Person person7 = new Person("孙策", 32, "吴国");
        Person person8 = new Person("太史慈", 32, "吴国");
        Person person9 = new Person("甘宁", 32, "吴国");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);
        personList.add(person9);
    }


    @Data
    @ToString
    @AllArgsConstructor
    private static class Person {
        private String name;
        private int age;
        private String group;
    }
}
