package demo.leetcode.medium;

/**
 * @Auther: zhouc
 * @Date: 2021/1/18 01:17
 * @Description: https://leetcode-cn.com/problems/reverse-words-in-a-string/ 151. 翻转字符串里的单词
 */
public class ReverseWords {
    /*public String reverseWords(String s) {
        s = s.replaceAll(" +", " ").trim();
        String[] strings = s.split(" ");
        int j = strings.length - 1;
        for (int i = 0; i < j; i++, j--) {
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
        }

        return String.join(" ",strings);
    }*/

    /**
     * 算法实现
     * 先分解再翻转
     * 分解字符串为数组，然后通过集合翻转操作，修改数组
     * 链接每个字符串
     * <p>
     * 一次性翻转
     * 1、一次性翻转字符串，然后依次翻转单词
     * 2、清理字符串前后空格，单词前后可能有多个空格
     */

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        getReverseWord(s, sb, 0, false);
        return sb.toString();
    }

    public void getReverseWord(String s, StringBuilder sb, int start, boolean flag) {
        int n = s.length();
        while (start < n && s.charAt(start) == ' ') start++;
        if (start == n) return;
        int end = start;
        while (end < n && s.charAt(end) != ' ') end++;
        getReverseWord(s, sb, end, true);
        sb.append(s.substring(start, end));

        if (flag) sb.append(' ');
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
    }
}
