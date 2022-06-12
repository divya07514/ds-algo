package ds_algo.divya.leetcode.practice;

public class MaxAreaOfIsland {
	static int max = 0;

	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] marked = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1 && !marked[i][j]) {
					int area = area(i, j, grid, marked);
					System.out.println(area);
					max = Math.max(max, area);
				}
			}
		}
		int result = max;
		max = 0;
		return result;
	}

	public static int area(int i, int j, int[][] grid, boolean[][] marked) {
		if (!validate(i, j, grid)) {
			return 0;
		}
		if (marked[i][j]) {
			return 0;
		}
		if(grid[i][j]==0) {
			return 0;
		}
		marked[i][j] = true;
		return (1 + area(i + 1, j, grid, marked) + area(i - 1, j, grid, marked) + area(i, j + 1, grid, marked)
				+ area(i, j - 1, grid, marked));

	}

	public static boolean validate(int i, int j, int[][] grid) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(maxAreaOfIsland(grid));

	}

}
