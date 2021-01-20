package demo.leecode.easy;

/**
 * @Auther: zhouc
 * @Date: 2021/1/17 00:15
 * @Description: https://leetcode-cn.com/problems/house-robber/ 198. 打家劫舍
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int prev = 0;
        int curr = 0;
        for (int num : nums) {
            int temp = Math.max(prev + num, curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
