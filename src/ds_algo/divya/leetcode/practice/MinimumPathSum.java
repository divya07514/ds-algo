package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		Map<String, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		int result = dfs(i, j, grid, map);
		return result;
	}

	public static int dfs(int i, int j, int[][] grid, Map<String, Integer> map) {
		if (i >= grid.length || j >= grid[0].length) {
			return Integer.MAX_VALUE;
		}
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}
		String key = i + "," + j;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int down = dfs(i + 1, j, grid, map);
		int right = dfs(i, j + 1, grid, map);
		int sum = grid[i][j] + Math.min(down, right);
		map.put(key, sum);
		return sum;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(grid));
	}

}
