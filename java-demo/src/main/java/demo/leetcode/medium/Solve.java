package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Date 2021/1/21 16:28
 * @Description https://leetcode-cn.com/problems/surrounded-regions/ 130. 被围绕的区域
 **/
public class Solve {

    private int[] rowsV = {-1, 1, 0, 0};
    private int[] colsV = {0, 0, -1, 1};

    boolean[][] visited = null;

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;

        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    dfs(i, j, board);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == 'X'||visited[i][j]) {
            return;
        }

        board[i][j] = '.';
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(i + rowsV[k], j + colsV[k], board);
        }
    }

    public static void main(String[] args) {
        char[] row1 = {'X', 'X', 'X', 'X'};
        char[] row2 = {'X', 'O', 'O', 'X'};
        char[] row3 = {'X', 'X', 'O', 'X'};
        char[] row4 = {'X', 'O', 'X', 'X'};

        char[][] board = {row1, row2, row3, row4};
        new Solve().solve(board);

        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
