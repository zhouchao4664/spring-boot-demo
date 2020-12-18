package demo.leecode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/12/18 14:33
 * @Description https://leetcode-cn.com/problems/triangle/description/ 120. 三角形最小路径和
 **/

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;
        int[] t = new int[triangle.size()+1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                t[j] = Math.min(t[j], t[j + 1]) + triangle.get(i).get(j);
            }
        }
        return t[0];
    }

    public static void main(String[] args) {
        List<Integer> list0 = Arrays.asList(2);
        List<Integer> list1 = Arrays.asList(3, 4);
        List<Integer> list2 = Arrays.asList(6, 5, 7);
        List<Integer> list3 = Arrays.asList(4, 1, 8, 3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);

        int result = new MinimumTotal().minimumTotal(triangle);
        System.out.println(result);

    }
}
