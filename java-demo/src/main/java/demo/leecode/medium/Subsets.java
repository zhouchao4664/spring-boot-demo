package demo.leecode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhouc
 * @Date: 2020/12/6 22:09
 * @Description: https://leetcode-cn.com/problems/subsets/ 78. 子集
 */
public class Subsets {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int j = 1 << n;
        for (int mask = 0; mask < j; mask++) {
            list.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    list.add(nums[i]);
                }
            }
            result.add(new ArrayList<>(list));
        }

        return result;
    }
}
