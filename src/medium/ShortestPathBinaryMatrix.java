package medium;

import java.util.LinkedList;

public class ShortestPathBinaryMatrix {
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 }, { 1, 1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		if (grid == null || grid.length == 0) {
			return 0;
		}
		if (grid[0][0] == 1 || grid[r - 1][c - 1] == 1) {
			return -1;
		}
		boolean[][] marked = new boolean[r][c];
		LinkedList<int[]> q = new LinkedList();
		q.add(new int[] { 0, 0 });
		int result = 0;
		marked[0][0] = true;
		while (!q.isEmpty()) {
			int qs = q.size();
			result++;
			while (qs > 0) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				if (x == r - 1 && y == c - 1) {
					return result;
				}
				for (int[] dir : dirs) {
					int nx = x + dir[0];
					int ny = y + dir[1];
					if (validate(nx, ny, grid, marked)) {
						marked[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
				qs--;
			}
		}
		return -1;
	}

	public boolean validate(int x, int y, int[][] grid, boolean[][] marked) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1 || marked[x][y]) {
			return false;
		}
		return true;
	}
}
