package demo.leetcode.easy;

import java.util.PriorityQueue;

/**
 * @Auther: zhouc
 * @Date: 2020/11/29 17:07
 * @Description: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/ 剑指 Offer 40. 最小的k个数
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        if (arr == null || k > len) return arr;
        if (k == 0) return new int[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        for (int i = 0; i < len; i++) {
            if (i < k) {
                pq.offer(arr[i]);
            } else if (arr[i] < pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        return pq.stream().mapToInt(Integer::intValue).toArray();

//        int[] vec = new int[k];
//        Arrays.sort(arr);
//        for (int i = 0; i < k; ++i) {
//            vec[i] = arr[i];
//        }
//        return vec;
    }

    public static void main(String[] args) {
        new GetLeastNumbers().getLeastNumbers(new int[]{3, 2, 1}, 2);
    }

}
