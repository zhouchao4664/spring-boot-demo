package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2020/11/18 18:41
 * @Description
 **/

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int result = 0;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
}
