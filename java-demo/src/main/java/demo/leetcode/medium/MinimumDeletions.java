package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Description 1653. 使字符串平衡的最少删除次数 https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 * 给你一个字符串s，它仅包含字符'a' 和'b' 。
 * 你可以删除s中任意数目的字符，使得s 平衡。当不存在下标对(i,j)满足i < j ，且s[i] = 'b' 的同时s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s平衡的 最少删除次数
 * @Date 2023/3/6 14:42
 */
public class MinimumDeletions {

    public int minimumDeletions(String s) {
        int f = 0;
        int cntB = 0;
        for (char c : s.toCharArray()) {
            // f 值不变
            if (c == 'b') {
                ++cntB;
            } else {
                f = Math.min(f + 1, cntB);
            }
        }
        return f;
    }


    public static void main(String[] args) {
        String s = "bbaaaaabb";
        System.out.println(new MinimumDeletions().minimumDeletions(s));
    }
}
