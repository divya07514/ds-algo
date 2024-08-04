package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * You have to check for each and every column, row and block. Pure brute force approach.
 * Useless and irritating question
 * @author divya.thakur
 *
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {
			Set<Character> rows = new HashSet();
			Set<Character> cols = new HashSet();
			for (int j = 0; j < 9; j++) {
				char r = board[i][j];
				char c = board[j][i];

				if (r != '.') {
					if (rows.contains(r)) {
						return false;
					} else {
						rows.add(r);
					}
				}

				if (c != '.') {
					if (cols.contains(c)) {
						return false;
					} else {
						cols.add(c);
					}
				}
			}
		}

		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				if (!block(i, j, board)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean block(int idxi, int idxj, char[][] board) {
		Set<Character> set = new HashSet();

		int rows = idxi + 3;
		int cols = idxj + 3;

		for (int i = idxi; i < rows; i++) {
			for (int j = idxj; j < cols; j++) {
				char c = board[i][j];

				if (c != '.') {
					if (set.contains(c)) {
						return false;
					}
					set.add(c);
				}
			}
		}

		return true;
	}
}
