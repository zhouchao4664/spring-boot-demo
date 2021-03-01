package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2021/3/1 14:39
 * @Description https://leetcode-cn.com/problems/range-sum-query-immutable/ 303. 区域和检索 - 数组不可变
 **/

public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        if (nums.length > 0) {
            int temp = 0;

            for (int i = 0; i < nums.length; i++) {
                temp = i == 0 ? nums[i] : temp + nums[i];
                sums[i] = temp;
            }
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }
}
