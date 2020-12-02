package demo.leecode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/12/2 20:42
 * @Description https://leetcode-cn.com/problems/generate-parentheses/ 22. 括号生成
 **/

public class GenerateParenthesis {

    private final static List<String> list = new ArrayList();

    public List<String> generateParenthesis(int n) {
        String s = "";
        generate(0, 0, s, n);
        return list;
    }

    private void generate(int preNum, int postNum, String s, int n) {
        if (postNum > preNum) return;
        if (preNum == n && postNum == n) {
            list.add(s);
            return;
        }
        if (preNum < n) {
            generate(preNum + 1, postNum, s + "(", n);
        }
        if (postNum < n) {
            generate(preNum, postNum + 1, s + ")", n);
        }
    }

    public static void main(String[] args) {
        List<String> list = new GenerateParenthesis().generateParenthesis(1);
        list.forEach(System.out::println);
    }
}
