package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * have to save state of grid at every step and pass it to the queue.
 * if final state has all 1's then you return the answer.
 * @author divya.thakur
 *
 */
public class MinimumMovestoSpreadStonesOverGrid {

	public static void main(String[] args) {
		 int[][] grid = { { 1, 1, 0 }, { 1, 1, 1 }, { 1, 2, 1 } };
		//int[][] grid = { { 1, 3, 0 }, { 1, 0, 0 }, { 1, 0, 3 } };
		System.out.println(minimumMoves(grid));

	}

	public static int minimumMoves(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int r = grid.length;
		int c = grid.length;

		LinkedList<int[][]> q = new LinkedList<int[][]>();
		q.add(grid);
		Set<String> set = new HashSet<>();
		set.add(stringyfy(grid));

		int[][] finalState = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		int result = 0;
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int[][] temp = q.poll();
				if (equals(temp, finalState)) {
					return result;
				}
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (temp[i][j] > 1) {
							for (int[] dir : dirs) {
								int ni = i + dir[0];
								int nj = j + dir[1];
								if (isValid(r, c, ni, nj)) {
									int[][] clone = deepClone(temp, r, c);
									clone[ni][nj]++;
									clone[i][j]--;
									if (!set.contains(stringyfy(clone))) {
										q.add(clone);
										set.add(stringyfy(clone));
									}
								}
							}
						}
					}
				}
				qs--;
			}
			result++;
		}
		return -1;
	}

	private static boolean isValid(int r, int c, int x, int y) {
		if (x >= 0 && x < r && y >= 0 && y < c) {
			return true;
		}
		return false;
	}

	private static String stringyfy(int[][] grid) {
		String result = "";
		for (int[] i : grid) {
			result = result + Arrays.toString(i) + ",";
		}
		return result;
	}

	private static int[][] deepClone(int[][] grid, int r, int c) {
		int[][] result = new int[r][c];
		int index = 0;
		for (int[] i : grid) {
			result[index++] = i.clone();
		}
		return result;
	}

	private static boolean equals(int[][] one, int[][] two) {
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < one[0].length; j++) {
				if (one[i][j] != two[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
