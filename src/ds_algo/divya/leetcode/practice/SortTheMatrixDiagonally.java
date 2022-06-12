package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTheMatrixDiagonally {

	/**
	 * Self implemented solution
	 * @param mat
	 * @return
	 */
	public static int[][] diagonalSort(int[][] mat) {

		int r = mat.length;
		int c = mat[0].length;

		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, String> index = new HashMap<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int diff = i - j;
				if (!map.containsKey(diff)) {
					List<Integer> list = new ArrayList<>();
					list.add(mat[i][j]);
					map.put(diff, list);
					if (!index.containsKey(diff)) {
						index.put(diff, i + "," + j);
					}
				} else {
					map.get(diff).add(mat[i][j]);
				}
			}
		}
		for (int key : map.keySet()) {
			List<Integer> list = map.get(key);
			Collections.sort(list);
			String[] array = index.get(key).split(",");
			int i = Integer.parseInt(array[0]);
			int j = Integer.parseInt(array[1]);
			for (int idx = 0; idx < list.size(); idx++) {
				if (i < r && j < c) {
					mat[i++][j++] = list.get(idx);
				}
			}
		}

		return mat;
	}
	
	public static void main(String[] args) {
		int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		ArrayUtil.print(diagonalSort(mat));
	}

}
