package ds_algo.divya.leetcode.practice;

public class PathWithMaximumGold {

	public static int getMaximumGold(int[][] grid) {
		int result = 0;
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] marked = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] != 0) {
					result = Math.max(result, dfs(i, j, marked, grid));
				}
			}
		}
		return result;
	}

	public static int dfs(int i, int j, boolean[][] marked, int[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || marked[i][j] || grid[i][j] == 0) {
			return 0;
		}
		int currentSum = grid[i][j];
		int max = 0;
		marked[i][j] = true;
		max = Math.max(max, dfs(i + 1, j, marked, grid));
		max = Math.max(max, dfs(i - 1, j, marked, grid));
		max = Math.max(max, dfs(i, j + 1, marked, grid));
		max = Math.max(max, dfs(i, j - 1, marked, grid));
		marked[i][j] = false;
		return max + currentSum;
	}

	public static void main(String[] args) {
		int[][] grid = { 
						{ 0, 6, 0 }, 
						{ 5, 8, 7 }, 
						{ 0, 9, 0 } 
					};

		System.out.println(getMaximumGold(grid));
	}

}
