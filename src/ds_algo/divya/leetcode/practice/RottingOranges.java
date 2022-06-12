package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int orangesRotting(int[][] grid) {

		int totalFresh = 0;
		LinkedList<int[]> q = new LinkedList<>();

		int r = grid.length;
		int c = grid[0].length;
		boolean[][] marked = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 0) {
					continue;
				} else if (grid[i][j] == 1) {
					totalFresh++;
				} else {
					q.add(new int[] { i, j });
				}
			}
		}

		if (totalFresh == 0) {
			return 0;
		}

		int result = 0;

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int[] temp = q.poll();
				marked[temp[0]][temp[1]] = true;
				for (int[] dir : directions) {
					int nr = temp[0] + dir[0];
					int nc = temp[1] + dir[1];
					if (nr < 0 || nr >= r || nc < 0 || nc >= c || marked[nr][nc] || grid[nr][nc] == 0) {
						continue;
					}
					if (grid[nr][nc] == 1) {
						totalFresh--;
						grid[nr][nc] =2;
						q.add(new int[] { nr, nc });
					}
				}
				qs--;
			}
			result++;
		}
		System.out.println(totalFresh);
		return totalFresh > 0 ? -1 : result - 1;

	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		System.out.println(orangesRotting(grid));
	}

}

class Pair {
	int x;
	int y;

	public Pair() {
	}

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
}
