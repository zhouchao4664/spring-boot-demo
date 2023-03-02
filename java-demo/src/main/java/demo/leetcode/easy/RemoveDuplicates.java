package demo.leetcode.easy;

/**
 * @Author zhouchao
 * @Date 2020/11/23 20:20
 * @Description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ 26. 删除排序数组中的重复项
 **/

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int numLength = nums.length;
        if(numLength==0) return 0;

        int j = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[j] != nums[i]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}
