package demo.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhouchao
 * @Description 3. 无重复字符的最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Date 2023/3/2 21:44
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Set set = new HashSet();
            int index = i;
            do {
                if (set.contains(s.charAt(index))) {
                    set.clear();
                    break;
                }
                set.add(s.charAt(index++));
                result = Math.max(result, index - i);
            } while (s.length() > index);
        }

        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int m = s.length();
        if (s.length() != 0){
            //初始值表示以s的第一个字符为结束的不重复的最长子串
            int num =1;
            int max =1;
            for(int i=1;i<m;i++){
                int index = s.indexOf(s.charAt(i),i-num);
                //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                if(index<i) {
                    num = i-index;
                } else {
                    num = num+1;
                }
                max = Math.max(max,num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = new LengthOfLongestSubstring().lengthOfLongestSubstring2(s);
        System.out.println(result);
    }

}
