package demo.leetcode.easy;

/**
 * @Author zhouchao
 * @Date 2021/1/20 15:41
 * @Description https://leetcode-cn.com/problems/plus-one/  66. 加一
 **/

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};

        int[] result = new PlusOne().plusOne(digits);
        for (int i : result) {
            System.out.print(i);
        }
        System.out.println();
    }
}
