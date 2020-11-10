package demo.base;

/**
 * @Author zhouchao
 * @Date 2020/11/9 22:09
 * @Description   https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 **/

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[j])
                nums[++j] = nums[i];
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,2,3};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
    }

}
