package demo.leecode.easy;

import java.util.*;

/**
 * @Author zhouchao
 * @Date 2021/1/26 13:49
 * @Description https://leetcode-cn.com/problems/valid-parentheses/ 20. 有效的括号
 **/

public class IsValid {
    public boolean isValid(String s) {
        char[] a = s.toCharArray();
        Stack<Character> result = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            char b = a[i];
            if (b == '[' || b == '{' || b == '(') {
                result.push(b);
            } else {
                if (b == ')' && (result.isEmpty() || result.pop() != '(')) return false;
                if (b == ']' && (result.isEmpty() || result.pop() != '[')) return false;
                if (b == '}' && (result.isEmpty() || result.pop() != '{')) return false;
            }
        }

        return result.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(new IsValid().isValid(s));
    }
}
