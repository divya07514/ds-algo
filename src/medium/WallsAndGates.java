package medium;

import java.util.LinkedList;

public class WallsAndGates {

	public void wallsAndGates(int[][] rooms) {

		LinkedList<int[]> q = new LinkedList();
		int r = rooms.length;
		int c = rooms[0].length;
		boolean[][] marked = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (rooms[i][j] == 0) {
					q.add(new int[] { i, j });
					marked[i][j] = true;
				}
			}
		}

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int dist = 1;

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				for (int[] i : dirs) {
					int nx = x + i[0];
					int ny = y + i[1];
					if (validate(nx, ny, r, c, rooms, marked)) {
						rooms[nx][ny] = dist;
						q.add(new int[] { nx, ny });
						marked[nx][ny] = true;
					}
				}
				qs--;
			}
			dist++;
		}

		return;
	}

	private boolean validate(int x, int y, int r, int c, int[][] rooms, boolean[][] marked) {
		if (x < 0 || x >= r || y < 0 || y >= c || rooms[x][y] == -1 || marked[x][y]) {
			return false;
		}
		return true;
	}

}
