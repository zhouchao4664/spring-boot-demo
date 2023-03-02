package demo.leetcode.difficult;

/**
 * @Auther: zhouc
 * @Date: 2021/1/3 20:14
 * @Description: https://leetcode-cn.com/problems/sudoku-solver/submissions/ 37. 解数独
 */
public class SolveSudoku {
    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][] grids;

    public void solveSudoku(char[][] board) {
        rows = new boolean[9][9];
        cols = new boolean[9][9];
        grids = new boolean[9][9];

        // 初始化棋盘
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' != board[i][j]) {
                    int num = board[i][j] - '0';
                    rows[i][num - 1] = true;
                    cols[j][num - 1] = true;
                    grids[i / 3 * 3 + j / 3][num - 1] = true;
                }
            }
        }
        dfs(0, 0, board);
    }

    private boolean dfs(int row, int col, char[][] board) {
        // 行遍历完，就完成了
        if (row > 8) return true;

        // 列遍历完，就遍历下一行
        if (col > 8) return dfs(row + 1, 0, board);

        //如果这个位置是数字，直接迭代下一格
        if ('.' != board[row][col]) return dfs(row, col + 1, board);

        for (int i = 0; i < 9; i++) {
            // 判断，如果行、列、块有这个数字i，就尝试i+1,如果1-9都不行就返回false
            if (rows[row][i] || cols[col][i] || grids[row / 3 * 3 + col / 3][i]) continue;

            // 将这格设为i
            board[row][col] = (char) ('0' + i + 1);
            rows[row][i] = true;
            cols[col][i] = true;
            grids[row / 3 * 3 + col / 3][i] = true;

            // 递归下一格，如果返回true,返回成功，
            if (dfs(row, col + 1, board)) return true;

            // 如果返回false就回溯
            board[row][col] = '.';
            rows[row][i] = false;
            cols[col][i] = false;
            grids[row / 3 * 3 + col / 3][i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] row0 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row1 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] row2 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] row3 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] row4 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] row5 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] row6 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] row7 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] row8 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        char[][] board = new char[9][9];
        board[0] = row0;
        board[1] = row1;
        board[2] = row2;
        board[3] = row3;
        board[4] = row4;
        board[5] = row5;
        board[6] = row6;
        board[7] = row7;
        board[8] = row8;

        new SolveSudoku().solveSudoku(board);

        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }
    }
}
