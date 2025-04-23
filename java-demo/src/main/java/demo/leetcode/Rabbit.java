package demo.leetcode;

/**
 * @Description: 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生-对兔子，假如兔子都不死，问第50个月的兔子总数为多少?
 * @Author : zhouchao
 * @Date : 2024-10-17 20:59
 *
 * 兔子的数量可以分为两部分，已经有的和新出生的，已经有的就是上一个月的兔子数量；以为从第三个月起开始生兔子，所以新出生的就是上上个月的，
 * 所以此题可以转为基础的斐波那契数列，就像爬楼梯，最后别忘了乘以2，因为一对兔子是2只
 *
 */
public class Rabbit {

    public static void main(String[] args) {
        Rabbit.count(50);
    }
    public static long count(int count) {
        // 第一个月的对数
        long i = 1;
        // 第二个月的对数
        long j = 1;
        // 总对数
        long n = 0;

        for (long k = 3; k <= 50; k++) {
            n = i + j;
            i = j;
            j = n;
            // 一对兔子是两只，所以要乘以2
            System.out.println("第" + k + "个月兔子的数量：" + n * 2);
        }
        return n;
    }
}
