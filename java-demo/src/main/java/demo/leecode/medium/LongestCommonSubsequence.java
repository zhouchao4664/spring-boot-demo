package demo.leecode.medium;

/**
 * @Auther: zhouc
 * @Date: 2020/12/14 22:15
 * @Description: https://leetcode-cn.com/problems/longest-common-subsequence/ 1143. 最长公共子序列
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] db = new int[t1.length + 1][t2.length + 1];
        for (int i = 1; i < t1.length+1; i++) {
            for (int j = 1; j < t2.length+1; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    db[i][j] = db[i - 1][j - 1] + 1;
                } else {
                    db[i][j] = Math.max(db[i - 1][j], db[i][j - 1]);
                }
            }
        }
        return db[t1.length][t2.length];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int result = new LongestCommonSubsequence().longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }
}
