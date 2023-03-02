package demo.leetcode.medium;

/**
 * @Auther: zhouc
 * @Date: 2020/12/6 17:55
 * @Description: https://leetcode-cn.com/problems/powx-n/ 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = myPow(x, Math.abs(n / 2));
        result *= result;
        if (n % 2 != 0) result *= x;
        if (n < 0) return 1 / result;
        return result;
    }

    public static void main(String[] args) {
        double result = new MyPow().myPow(2.0000, -2147483648);
        System.out.println(result);
    }
}
