package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2020/11/24 00:58
 * @Description https://leetcode-cn.com/problems/sorted-merge-lcci/ 面试题 10.01. 合并排序的数组
 **/
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            nums1[m + n - 1] = m > 0 && nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        new Merge().merge(nums1, 3, nums2, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+" ");
        }
    }


}
