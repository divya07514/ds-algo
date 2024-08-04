package medium;

public class SolveSudoku {

	public void solveSudoku(char[][] board) {
		solve(board);
	}

	private boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (check(c, i, j, board)) {
							board[i][j] = c;
							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean check(char c, int row, int col, char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c) {
				return false;
			}
			if (board[i][col] == c) {
				return false;
			}
			int bx = 3 * (row / 3) + i / 3;
			int bc = 3 * (col / 3) + i % 3;
			if (board[bx][bc] == c) {
				return false;
			}
		}
		return true;
	}
}
