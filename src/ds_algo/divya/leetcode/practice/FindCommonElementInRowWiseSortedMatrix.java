package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCommonElementInRowWiseSortedMatrix {

	public static int find_extraSpace(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int i : matrix[0]) {
			set.add(i);
		}
		for (int i = 1; i < matrix.length; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j : matrix[i]) {
				temp.add(j);
			}
			set.retainAll(temp);
		}
		if (set.isEmpty()) {
			return -1;
		}
		int result = 0;
		for (int i : set) {
			result = i;
		}
		return result;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 }, };

		System.out.println(find_extraSpace(matrix));
	}

}
