package demo.base;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2019/10/29 11:08
 * @Description
 **/

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        Map<String, Object> map = new IdentityHashMap<>();

        String oldString = "123";
        String newString = new String("123");

        map.put(oldString, "oldString");
        map.put(newString,"newString");

        System.out.println(map.get(oldString));
        System.out.println(map.get(newString));
    }
}
