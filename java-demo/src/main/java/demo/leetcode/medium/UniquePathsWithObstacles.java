package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/17 19:16
 * @Description https://leetcode-cn.com/problems/unique-paths-ii/ 63. 不同路径 II
 **/

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] fib = new int[m + 1][n + 1];

        // 实际上是想给fib[m-1][n-1]一个初始值。所以fib[m][n-1]=1也可以
        fib[m-1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //碰到石头不处理，继续循环
                if (obstacleGrid[i][j] == 1) {
                    continue;
                } else {
                    // 公式：左边的路径+上边的路径=本格路径
                    fib[i][j] = fib[i + 1][j] + fib[i][j + 1];
                }
            }
        }

        return fib[0][0];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int result = new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
}
