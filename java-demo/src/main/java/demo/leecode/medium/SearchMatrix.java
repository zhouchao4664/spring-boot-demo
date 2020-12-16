package demo.leecode.medium;

/**
 * @Auther: zhouc
 * @Date: 2020/12/16 23:06
 * @Description: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 240. 搜索二维矩阵 II
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] first = matrix[0];
        //二分查找，找到第一列的target索引，如果找不到，就找比他小且最接近的数字的索引
        int i = binarySearch(first,0,first.length-1,target);

        // 看测试用例了，数组小的话，还不如直接遍历
        /*int i = 0;
        for (; i < first.length; i++) {
            if (first[i]>target) {
                i--;
                break;
            }
        }
        i = Math.min(i,first.length-1);*/

        int j = 0;
        while (j<matrix.length && i>=0) {
            if (matrix[j][i] == target) {
                // 如果相等返回true
                return true;
            } else if (matrix[j][i] < target) {
                //如果比target小，向下移动
                j++;
            }else{
                //如果比target大，向左移动
                i--;
            }
        }
        return false;
    }

    public int binarySearch(int[] nums, int start, int end,int target) {
        if (nums[end] <= target) return end;
        if (end-start<=1){
            if (nums[start] <= target) {
                return start;
            }else {
                return --start;
            }
        }
        int mid = (start+end) / 2;
        if (nums[mid] == target) {
            return mid;
        }else if (nums[mid] < target){
            return binarySearch(nums,mid,end,target);
        }else {
            return binarySearch(nums,start,mid,target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,5};
        int result = new SearchMatrix().binarySearch(nums,0,nums.length-1,6);

        System.out.println(result);
    }

}
