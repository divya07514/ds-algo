package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsGraphBipartite {

	static boolean isBipartite = true;
	static boolean[] marked;
	static boolean[] color;
	static Map<Integer, List<Integer>> map = new HashMap<>();

	public static boolean isBipartite(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return false;
		}
		for (int i = 0; i < graph.length; i++) {
			int[] temp = graph[i];
			List<Integer> list = new ArrayList<>();
			for (int j : temp) {
				list.add(j);
			}
			map.put(i, list);
		}
		System.out.println(map);
		marked = new boolean[map.size()];
		color = new boolean[map.size()];
		for (int s : map.keySet()) {
			if (!marked[s]) {
				if (!isBipartite) {
					break;
				}
				dfs(s);
			}
		}
		boolean result = isBipartite;
		isBipartite = true;
		map.clear();
		Arrays.fill(marked, false);
		Arrays.fill(color, false);
		return result;
	}

	public static void dfs(int s) {
		marked[s] = true;
		if (map.containsKey(s)) {
			for (int i : map.get(s)) {
				if (!marked[i]) {
					color[i] = !color[s];
					dfs(i);
				} else if (color[s]==color[i]) {
					isBipartite = false;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[][] graph = {{1},{0,3},{3},{1,2}};
		System.out.println(isBipartite(graph));
	}

}
