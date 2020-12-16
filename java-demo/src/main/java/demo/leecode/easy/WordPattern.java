package demo.leecode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2020/12/16 14:53
 * @Description https://leetcode-cn.com/problems/word-pattern/ 290. 单词规律
 **/

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] p = pattern.toCharArray();
        String[] str = s.split(" ");
        if (p.length != str.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            if (!map.containsKey(p[i])) {
                if (map.containsValue(str[i])) return false;
                map.put(p[i], str[i]);
            } else if (!map.get(p[i]).equals(str[i])) {
                return false;
            }
        }

        return true;
    }
}
