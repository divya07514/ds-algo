package medium;

/**
 * Start from the 1's that are on the boundary and mark all the other 1's that are connected to these.
 * All the other un marked 1's are the answer
 * @author divya.thakur
 *
 */
public class NumberofEnclaves {

	public int numEnclaves(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] marked = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			if (grid[i][0] == 1) {
				dfs(i, 0, grid, marked);
			}
		}

		for (int i = 0; i < c; i++) {
			if (grid[0][i] == 1) {
				dfs(0, i, grid, marked);
			}
		}

		for (int i = 0; i < r; i++) {
			if (grid[i][c - 1] == 1) {
				dfs(i, c - 1, grid, marked);
			}
		}

		for (int i = 0; i < c; i++) {
			if (grid[r - 1][i] == 1) {
				dfs(r - 1, i, grid, marked);
			}
		}

		int result = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1 && !marked[i][j]) {
					result++;
				}
			}
		}

		return result;
	}

	private void dfs(int i, int j, int[][] grid, boolean[][] marked) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || marked[i][j] || grid[i][j] != 1) {
			return;
		}
		marked[i][j] = true;
		dfs(i + 1, j, grid, marked);
		dfs(i - 1, j, grid, marked);
		dfs(i, j - 1, grid, marked);
		dfs(i, j + 1, grid, marked);
	}

}
