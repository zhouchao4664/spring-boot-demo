package demo.leecode.medium;

/**
 * @Auther: zhouc
 * @Date: 2021/1/21 22:40
 * @Description: https://leetcode-cn.com/problems/valid-sudoku/description/ 36. 有效的数独
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '0';

                if (rows[i][num - 1] || cols[j][num - 1] || grids[(i / 3 * 3) + (j / 3)][num - 1]) return false;
                rows[i][num - 1] = true;
                cols[j][num - 1] = true;
                grids[(i / 3 * 3) + (j / 3)][num - 1] = true;
            }
        }
        return true;
    }
}
