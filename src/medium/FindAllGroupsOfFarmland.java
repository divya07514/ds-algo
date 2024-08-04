package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
	int x = 0;
	int y = 0;

	public int[][] findFarmland(int[][] land) {
		if (land == null || land.length == 0) {
			return new int[0][0];
		}
		int r = land.length;
		int c = land[0].length;
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (land[i][j] == 1) {
					dfs(i, j, land);
					list.add(new int[] { i, j, x, y });
				}
				x = 0;
				y = 0;
			}

		}
		int[][] result = new int[list.size()][4];
		int index = 0;
		for (int[] i : list) {
			result[index++] = i;
		}
		return result;
	}

	private void dfs(int i, int j, int[][] land) {
		if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 1) {
			return;
		}
		land[i][j] = 0;
		dfs(i + 1, j, land);
		dfs(i, j + 1, land);
		x = Math.max(i, x);
		y = Math.max(j, y);
	}

}
