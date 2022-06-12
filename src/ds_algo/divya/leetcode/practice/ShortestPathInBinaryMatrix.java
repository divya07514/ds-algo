package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathInBinaryMatrix {

	private static final int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 },
			{ 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static int shortestPathBinaryMatrix(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return -1;
		}

		if (grid.length == 1 && grid[0][0] == 0) {
			return 1;
		}

		if (grid.length == 1 && grid[0][0] == 1) {
			return -1;
		}

		int r = grid.length;
		int c = grid[0].length;

		if (grid[0][0] != 0 || grid[r - 1][c - 1] != 0) {
			return -1;
		}

		LinkedList<int[]> q = new LinkedList<>();
		boolean[][] marked = new boolean[r][c];
		q.add(new int[] {0,0});
		marked[0][0] = true;
		int result = 1;

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int[] temp = q.poll();
				int row = temp[0];
				int col = temp[1];
				if (row == r - 1 && col == c - 1) {
					return result;
				}
				List<int[]> list = getAll(row,col,grid);
				for (int[] array : list) {
					int newrow = array[0];
					int newcol = array[1];
					if (marked[newrow][newcol]) {
						continue;
					}
					marked[newrow][newcol] = true;
					q.add(new int[] { newrow, newcol });
					System.out.println(newrow + ", " + newcol);
				}

				qs--;
			}
			System.out.println();
			result = result + 1;
		}
		return -1;
	}

	public static List<int[]> getAll(int i, int j, int[][] grid) {
		List<int[]> list = new ArrayList<>();
		for (int[] array : directions) {
			int r = i + array[0];
			int c = j + array[1];
			if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 0) {
				continue;
			}
			list.add(new int[] { r, c });
		}
		return list;
	}

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0,0},{0,1,0,0,0},{0,0,0,0,1},{0,1,1,1,0},{0,1,0,0,0}};
		System.out.println(shortestPathBinaryMatrix(grid));

	}

}
