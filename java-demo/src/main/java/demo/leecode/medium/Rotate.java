package demo.leecode.medium;

/**
 * @Author zhouchao
 * @Date 2020/11/23 20:29
 * @Description https://leetcode-cn.com/problems/Rotate-array/
 **/

public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] += nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start++] -= nums[end--];
        }
    }

    public static void main(String[] args) {
        System.out.println("开始");

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Rotate().rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("结束");
    }
}
