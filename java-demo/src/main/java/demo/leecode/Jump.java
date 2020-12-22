package demo.leecode;

/**
 * @Auther: zhouc
 * @Date: 2020/12/20 23:46
 * @Description:
 */
public class Jump {
    public int jump(int[] nums) {
        int index = nums.length - 1;

        int count = getCount(index, 0, nums);
        return count;
    }

    public int getCount(int index, int count, int[] nums) {
        int result = 0;

        if (index == 0) {
            return count;
        }

        for (int i = 0; i <= index; i++) {
            if (nums[i] + i < index) continue;

            result = getCount(i,count+1,nums);
            break;
        }
        return result;
    }
}
