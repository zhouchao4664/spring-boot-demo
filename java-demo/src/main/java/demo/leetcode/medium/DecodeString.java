package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Date 2021/1/27 15:16
 * @Description https://leetcode-cn.com/problems/decode-string/ 394. 字符串解码
 **/

public class DecodeString {
    private int index = 0;

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c - '0' >= 0 && c - '0' <= 9) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String subString = s.substring(i + 1);
                String subResult = decodeString(subString);
                for (int j = 0; j < num; j++) {
                    sb.append(subResult);
                }
                i = s.length() - index;
                num = 0;
            } else if (c == ']') {
                index = s.length() - i;
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new DecodeString().decodeString(s));
    }
}
