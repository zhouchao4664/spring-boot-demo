package demo.leecode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/17 11:29
 * @Description https://leetcode-cn.com/problems/unique-paths/ 62. 不同路径
 **/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] fib = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    // 将start同行,同列的数字变为1
                    fib[i][j] = 1;
                } else {
                    // 公式：左边的路径+上边的路径=本格路径
                    fib[i][j] = fib[i - 1][j] + fib[i][j - 1];
                }
            }
        }
        return fib[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int result = new UniquePaths().uniquePaths(3, 7);
        System.out.println(result);
    }
}
