package demo.leecode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/17 19:16
 * @Description https://leetcode-cn.com/problems/unique-paths-ii/ 63. 不同路径 II
 **/

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] fib = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                //碰到石头停止循环
                if (obstacleGrid[i][j] == 1) continue;

                if (j == n-1 || i == m-1) {
                    // 将Finish同行,同列的数字变为1
                    fib[i][j] = 1;
                } else {
                    // 公式：左边的路径+上边的路径=本格路径
                    fib[i][j] = fib[i + 1][j] + fib[i][j + 1];
                }
            }
        }

        return fib[0][0];
    }
}
