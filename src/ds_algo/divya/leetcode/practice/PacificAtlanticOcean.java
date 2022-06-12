package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticOcean {

	private static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return new ArrayList<>();
		}

		int r = matrix.length;
		int c = matrix[0].length;

		Queue<int[]> pq = new LinkedList<>();
		Queue<int[]> aq = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			pq.add(new int[] { i, 0 });
			aq.add(new int[] { i, c - 1 });
		}

		for (int i = 0; i < c; i++) {
			pq.add(new int[] { 0, i });
			aq.add(new int[] { r - 1, i });
		}

		boolean[][] pr = bfs(pq, r, c, matrix);
		boolean[][] ar = bfs(aq, r, c, matrix);

		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (pr[i][j] && ar[i][j]) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					result.add(list);
				}
			}
		}

		return result;
	}

	public boolean[][] bfs(Queue<int[]> q, int r, int c, int[][] matrix) {
		boolean[][] result = new boolean[r][c];
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			result[temp[0]][temp[1]] = true;
			for (int i = 0; i < directions.length; i++) {
				int[] dir = directions[i];
				int nr = temp[0] + dir[0];
				int nc = temp[1] + dir[1];
				if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
					continue;
				}
				if (result[nr][nc]) {
					continue;
				}
				if (matrix[nr][nc] < matrix[temp[0]][temp[1]]) {
					continue;
				}
				q.add(new int[] { nr, nc });
			}
		}
		return result;
	}
}
