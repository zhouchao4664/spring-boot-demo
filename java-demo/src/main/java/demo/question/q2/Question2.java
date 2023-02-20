package demo.question.q2;

/**
 * 1、走阶梯，有n级阶梯，一次可以走一级、两级或者三级，请编写一个函数计算走完该阶梯一共有多少种种方法
 * 2020/5/18
 * zhouchao
 * <p>
 * f(n) = f(n-1) + f(n-2) + f(n-3)
 */
public class Question2 {

    public static void main(String[] args) {
        int n = 5;
        int result = func(n);
        System.out.println(result);
    }

    private static int func(int n) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        return func(n - 1) + func(n - 2) + func(n - 3);
    }

}
