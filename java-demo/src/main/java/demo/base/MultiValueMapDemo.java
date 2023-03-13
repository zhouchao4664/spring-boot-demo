package demo.base;

import org.springframework.util.LinkedMultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2019/3/12
 * zhouchao
 */
public class MultiValueMapDemo {
    public static void main(String[] args) {
        Map<String, Object> map = new LinkedMultiValueMap();

        map.put("key", Arrays.asList("oldString"));
        map.put("key", Arrays.asList("newString"));
        System.out.println(map.get("key"));

        map.put("key", Arrays.asList("oldString", "newString"));
        System.out.println(map.get("key"));

        Map<String, Object> hashMap = new HashMap();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i + "alfjklds", "123");
        }

        System.out.println(hashMap.get("5"));
    }
}
