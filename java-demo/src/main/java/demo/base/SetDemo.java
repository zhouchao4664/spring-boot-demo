package demo.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 2019/2/23
 * zhouchao
 */
public class SetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        set.forEach(System.out::println);

        set.clear();
        set.add("1");
        set.add("2");
        set.add("3");

        set.forEach(System.out::println);

        set.clear();
        set.add("都是风景啊");
        set.add("撒打飞机了");
        set.add("圣诞节开发");

        set.forEach(System.out::println);
    }


}
