package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendCircles {

	static int counter;

	public static int findCircleNum(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 1) {
					if (!map.containsKey(i)) {
						List<Integer> list = new ArrayList<>();
						list.add(j);
						map.put(i, list);
					} else {
						map.get(i).add(j);
					}
				}
			}
		}
		counter = 0;
		Set<Integer> marked = new HashSet<>();
		for (int key : map.keySet()) {
			if (!marked.contains(key)) {
				dfs(key, map, marked);
				counter++;
			}
		}
		return counter;
	}

	public static void dfs(int key, Map<Integer, List<Integer>> map, Set<Integer> marked) {
		marked.add(key);
		for (int i : map.get(key)) {
			if (!marked.contains(i)) {
				dfs(i, map, marked);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(matrix));

	}

}
