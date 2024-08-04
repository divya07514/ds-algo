package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;

		if (r == 0 && c == 0) {
			return new ArrayList();
		}

		int sr = 0;
		int er = r - 1;
		int sc = 0;
		int ec = c - 1;
		int dir = 0;
		List<Integer> list = new ArrayList();

		while (sr <= er && sc <= ec) {
			if (dir == 0) {// go right
				for (int i = sc; i <= ec; i++) {
					list.add(matrix[sr][i]);
				}
				sr++;
			} else if (dir == 1) {// go down
				for (int i = sr; i <= er; i++) {
					list.add(matrix[i][ec]);
				}
				ec--;
			} else if (dir == 2) {// go left
				for (int i = ec; i >= sc; i--) {
					list.add(matrix[er][i]);
				}
				er--;
			} else {// go up
				for (int i = er; i >= sr; i--) {
					list.add(matrix[i][sc]);
				}
				sc++;
			}
			System.out.println(dir);
			dir = (dir + 1) % 4;
		}
		return list;
	}
}
