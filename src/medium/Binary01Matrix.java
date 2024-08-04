package medium;

import java.util.LinkedList;

public class Binary01Matrix {
	
	public int[][] updateMatrix(int[][] mat) {
		if (mat == null || mat.length == 0) {
			return new int[0][0];
		}
		LinkedList<int[]> q = new LinkedList();
		int r = mat.length;
		int c = mat[0].length;
		boolean[][] marked = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (mat[i][j] == 0) {
					q.add(new int[] { i, j });
				}
			}
		}
		int step = 0;
		while (!q.isEmpty()) {
			int qs = q.size();
			step++;
			while (qs > 0) {
				int[] temp = q.poll();
				int i = temp[0];
				int j = temp[1];
				if (i - 1 >= 0 && mat[i - 1][j] == 1 && !marked[i - 1][j]) {
					mat[i - 1][j] = step;
					marked[i - 1][j] = true;
					q.add(new int[] { i - 1, j });
				}
				if (i + 1 < mat.length && mat[i + 1][j] == 1 && !marked[i + 1][j]) {
					mat[i + 1][j] = step;
					marked[i + 1][j] = true;
					q.add(new int[] { i + 1, j });
				}
				if (j - 1 >= 0 && mat[i][j - 1] == 1 && !marked[i][j - 1]) {
					mat[i][j - 1] = step;
					marked[i][j - 1] = true;
					q.add(new int[] { i, j - 1 });
				}
				if (j + 1 < mat[0].length && mat[i][j + 1] == 1 && !marked[i][j + 1]) {
					mat[i][j + 1] = step;
					marked[i][j + 1] = true;
					q.add(new int[] { i, j + 1 });
				}
				qs--;
			}
		}
		return mat;

	}
}
