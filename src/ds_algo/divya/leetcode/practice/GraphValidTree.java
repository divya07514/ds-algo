package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree {
	
	public static boolean validTree(int n, int[][] edges) {
		if (edges.length == 0 && n == 1) {
			return true;
		}
		if (edges.length == 0 && n != 1) {
			return false;
		}
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int[] temp = edges[i];
			int one = temp[0];
			int two = temp[1];
			if (!graph.containsKey(one)) {
				List<Integer> list = new ArrayList<>();
				list.add(two);
				graph.put(one, list);
			} else {
				graph.get(one).add(two);
			}
			if (!graph.containsKey(two)) {
				List<Integer> list = new ArrayList<>();
				list.add(one);
				graph.put(two, list);
			} else {
				graph.get(two).add(one);
			}
		}
		boolean[] marked = new boolean[n];
		boolean result = false;
		int components = 0;
		for (int i = 0; i < n; i++) {
			if (!marked[i]) {
				result = dfs(i, i, graph, marked);
				if (result) {
					return false;
				}
				components++;
			}
		}
		if (components > 1) {
			return false;
		}
		return true;

	}

	public static boolean dfs(int s, int parent, Map<Integer, List<Integer>> graph, boolean[] marked) {
		marked[s] = true;
		if (graph.containsKey(s)) {
			for (int i : graph.get(s)) {
				if (!marked[i]) {
					dfs(i, s, graph, marked);
				} else if (i != parent) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		System.out.println(validTree(n, edges));

	}

}
