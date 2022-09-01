package demo.leecode.easy;

import java.util.Arrays;

/**
 * @Author zhouchao
 * @Date 2022/9/1 9:50
 * @Description: 题目：有两个有序、不包含重复数字的整数数组a=[9, 22, 35, 72, …]，b=[2, 14, 22, 35, 41, 42, …]，
 * 但是两个数组之间可能会有重复数字。将它们合并为一个新的有序、不包含重复数字的整数数组c=[2, 9, 14, 22, 35, 41, 42, …]。
 */
public class Selenium {


    public static void main(String[] args) {
        int[] a = {9, 22, 35, 72};
        int[] b = {2, 14, 22, 35, 41, 42};

        int[] c = selenium(a, b);

        for (int i : c) {
            System.out.print(i + " ");
        }
    }

    private static int[] selenium(int[] a, int[] b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int indexA = 0, indexB = 0;
        int[] c = new int[a.length + b.length];
        int i = 0;
        for (; indexA + indexB < c.length; i++) {
            c[i] = indexA == a.length ? b[indexB++] :
                    (indexB == b.length ? a[indexA++] :
                            (b[indexB] > a[indexA] ? a[indexA++] : (
                                    b[indexB] < a[indexA] ? b[indexB++] : a[indexA++] + b[indexB] - b[indexB++]
                            )));
        }
        return Arrays.copyOfRange(c, 0, i);
    }
}
