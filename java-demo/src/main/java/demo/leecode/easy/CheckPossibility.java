package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2021/2/7 11:16
 * @Description https://leetcode-cn.com/problems/non-decreasing-array/ 665. 非递减数列
 **/

public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) return true;
        int count = 0;
        if (nums[0]>nums[1]) {
            count++;
            nums[0] = nums[1];
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i]<nums[i-1]){
                if (count++ == 1) return false;

                if (nums[i]<nums[i-2]){
                    nums[i] = nums[i-1];
                }else{
                    nums[i-1] = nums[i];
                }
            }
        }
        return true;
    }
}
