package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2020/11/18 18:41
 * @Description
 **/

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=3) return n;

        int f1 = 1;
        int f2 = 2;
        for(int i =3;i<=n;i++){
            f2 += f1;
            f1 = f2-f1;
        }
        return f2;
    }

    public static void main(String[] args) {
        int n = 7;
        new ClimbingStairs().climbStairs(n);
    }
}
