package demo.leetcode.easy;

/**
 * @Author zhouchao
 * @Date 2021/2/25 17:18
 * @Description https://leetcode-cn.com/problems/transpose-matrix/ 867. 转置矩阵
 **/

public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
