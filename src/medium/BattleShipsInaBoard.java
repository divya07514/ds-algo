package medium;

public class BattleShipsInaBoard {

	public int countBattleships(char[][] board) {
		int r = board.length;
		int c = board[0].length;

		if (r == 0 || c == 0) {
			return 0;
		}

		boolean[][] marked = new boolean[r][c];
		int result = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				char ch = board[i][j];
				if (ch == 'X' && !marked[i][j]) {
					checkRows(i, j, board, marked);
					checkCols(i, j, board, marked);
					result++;
				}
			}
		}
		return result;
	}

	private void checkRows(int i, int j, char[][] board, boolean[][] marked) {
		while (i < board.length && board[i][j] == 'X') {
			marked[i][j] = true;
			i++;
		}
	}

	private void checkCols(int i, int j, char[][] board, boolean[][] marked) {
		while (j < board[0].length && board[i][j] == 'X') {
			marked[i][j] = true;
			j++;
		}
	}

}
