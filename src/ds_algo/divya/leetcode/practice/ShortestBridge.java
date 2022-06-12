package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class ShortestBridge {
	public static int shortestBridge(int[][] grid) {

		int r = grid.length;
		int c = grid[0].length;

		LinkedList<int[]> q = new LinkedList<>();
		int count = 0;
		boolean found = false;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1 && !found) {
					dfs(i, j, grid);
					found = true;
				}
				if (found && grid[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}
		int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		while (!q.isEmpty()) {
			int qs = q.size();
			while(qs > 0) {
				int[] temp = q.poll();
				for (int[] dir : directions) {
					int nr = temp[0] + dir[0];
					int nc = temp[1] + dir[1];
					if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
						continue;
					}
					if (grid[nr][nc] == -1) {
						return count;
					}
					if (grid[nr][nc] == 1) {
						continue;
					}
					if (grid[nr][nc] == 0) {
						grid[nr][nc] = 1;
						q.add(new int[] { nr, nc });
					}
				}
				qs--;
			}
			count++;
		}

		return -1;
	}

	public static void dfs(int i, int j, int[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = -1;
		dfs(i - 1, j, grid);
		dfs(i + 1, j, grid);
		dfs(i, j - 1, grid);
		dfs(i, j + 1, grid);
	}

	public static void main(String[] args) {
		int[][] grid= {{0,1,0},{0,0,0},{0,0,1}};
		System.out.println(shortestBridge(grid));
	}

}
