package ds_algo.divya.leetcode.practice;

public class NumberOfClosedIslands {
	
	public static int closedIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int r = grid.length;
		int c = grid[0].length;
		for (int i = 0; i < c; i++) {
			if (grid[0][i] == 0) {
				dfs(0, i, grid);
			}
		}
		for (int i = 0; i < c; i++) {
			if (grid[r - 1][i] == 0) {
				dfs(r - 1, i, grid);
			}
		}
		for (int i = 0; i < r; i++) {
			if (grid[i][0] == 0) {
				dfs(i, 0, grid);
			}
		}
		for (int i = 0; i < r; i++) {
			if (grid[i][c - 1] == 0) {
				dfs(i, c - 1, grid);
			}
		}
		int count = 0;
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (grid[i][j] == 0) {
					dfs(i, j, grid);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int i, int j, int[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == 1) {
			return;
		}
		if (grid[i][j] == 0) {
			grid[i][j] = 1;
		}
		dfs(i - 1, j, grid);
		dfs(i + 1, j, grid);
		dfs(i, j - 1, grid);
		dfs(i, j + 1, grid);
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		System.out.println(closedIsland(grid));
	}

}
