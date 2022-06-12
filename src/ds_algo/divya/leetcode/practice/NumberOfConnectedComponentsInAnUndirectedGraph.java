package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

	public static int countComponents(int n, int[][] edges) {

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < edges.length; i++) {
			int[] temp = edges[i];
			int one = temp[0];
			int two = temp[1];
			if (!map.containsKey(one)) {
				List<Integer> list = new ArrayList<>();
				list.add(two);
				map.put(one, list);
			} else {
				map.get(one).add(two);
			}

			if (!map.containsKey(two)) {
				List<Integer> list = new ArrayList<>();
				list.add(one);
				map.put(two, list);
			} else {
				map.get(two).add(one);
			}
		}
		System.out.println(map);
		int result = 0;
		boolean[] marked = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!marked[i]) {
				dfs(i, marked, map);
				result = result + 1;
			}
		}
		return result;
	}

	public static void dfs(int s, boolean[] marked, Map<Integer, List<Integer>> map) {
		marked[s] = true;
		if (map.containsKey(s)) {
			for (int i : map.get(s)) {
				if(!marked[i]) {
					dfs(i, marked, map);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 5 ;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(countComponents(n, edges));
	}

}
