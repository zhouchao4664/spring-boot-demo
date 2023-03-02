package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/18 17:56
 * @Description https://leetcode-cn.com/problems/maximum-product-subarray/ 152. 乘积最大子数组
 **/

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        for (int n : nums) {
            if(n<0){
                max += min;
                min = max-min;
                max = max-min;
            }
            max = Math.max(max * n, n);
            min = Math.min(min * n, n);

            result = Math.max(max, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, 8};
        int result = new MaxProduct().maxProduct(nums);
        System.out.println(result);
    }
}
