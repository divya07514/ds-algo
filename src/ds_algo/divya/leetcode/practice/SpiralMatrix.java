package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] marked = new boolean[row][col];
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int r = 0;
		int c = 0;
		int dir = 0;
		for (int i = 0; i < row * col; i++) {
			result.add(matrix[r][c]);
			marked[r][c] = true;
			int[] temp = directions[dir];
			int nr = r + temp[0];
			int nc = c + temp[1];
			if (nr >= 0 && nr < row && nc >= 0 && nc < col && !marked[nr][nc]) {
				r = nr;
				c = nc;
			} else {
				dir = (dir + 1) % 4;
				int[] change = directions[dir];
				r = r + change[0];
				c = c + change[1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));
	}

}
