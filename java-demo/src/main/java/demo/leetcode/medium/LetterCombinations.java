package demo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhouchao
 * @Description 17. 电话号码的字母组合 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Date 2023/3/6 9:54
 */
public class LetterCombinations {

    List<String> str = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        dfs("", digits, result, 0);

        return result;
    }

    /**
     * @param s
     * @param digits
     * @param result
     * @param i
     * @description: 利用深度优先解答
     * @author: zhouchao
     * @version: 1.0.0
     * @date: 2023/3/6 11:59
     */
    private void dfs(String s, String digits, List<String> result, int i) {

        int length = digits.length();
        if (i == length) {
            result.add(s);
            return;
        }

        for (char c : str.get(digits.charAt(i) - '0').toCharArray()) {
            String nexts = s + c;
            dfs(nexts, digits, result, i + 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = new LetterCombinations().letterCombinations(digits);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
