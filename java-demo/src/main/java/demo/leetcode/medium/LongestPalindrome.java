package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Description 5. 最长回文子串 https://leetcode.cn/problems/longest-palindromic-substring/
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串
 * @Date 2023/3/4 23:02
 */
public class LongestPalindrome {

    // 动态规划解法 dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
    public String longestPalindrome(String s) {
        int len = s.length();

        if (s.length() < 2) {
            return s;
        }

        int maxLenth = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    if (dp[i][j] && j - i + 1 > maxLenth) {
                        maxLenth = j - i + 1;
                        begin = i;
                    }
                }


            }
        }

        return s.substring(begin, begin + maxLenth);
    }

}
