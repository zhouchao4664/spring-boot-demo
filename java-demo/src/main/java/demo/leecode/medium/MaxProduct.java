package demo.leecode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/18 17:56
 * @Description https://leetcode-cn.com/problems/maximum-product-subarray/ 152. 乘积最大子数组
 **/

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = nums[0], imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, 8};
        int result = new MaxProduct().maxProduct(nums);
        System.out.println(result);
    }
}
