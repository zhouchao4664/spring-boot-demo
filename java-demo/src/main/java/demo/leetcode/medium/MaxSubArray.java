package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/18 16:41
 * @Description https://leetcode-cn.com/problems/maximum-subarray/ 53. 最大子序和
 **/

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int i : nums) {
            if (sum > 0) {
                sum += i;
            } else {
                sum = i;
            }
            result = Math.max(sum, result);
        }
        return result;
    }
}
