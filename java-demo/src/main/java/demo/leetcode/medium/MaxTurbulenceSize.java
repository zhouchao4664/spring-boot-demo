package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Date 2021/2/8 11:04
 * @Description https://leetcode-cn.com/problems/longest-turbulent-subarray/ 978. 最长湍流子数组
 **/

public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int maxSize = 0;
        int[][] dp = new int[arr.length][2];

        dp[0][0] = dp[0][1] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (arr[i] > arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                maxSize = Math.max(maxSize,dp[i][1]);
            } else if (arr[i] < arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                maxSize = Math.max(maxSize,dp[i][0]);
            }
        }
        return maxSize;
    }
}
