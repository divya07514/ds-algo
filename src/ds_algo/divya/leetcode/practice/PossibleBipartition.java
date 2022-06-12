package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBipartition {
	
	static boolean isBipartite = true;
	static Map<Integer, List<Integer>> map;
	static boolean[] color;
	static boolean[] marked;

	public static boolean possibleBipartition(int N, int[][] graph) {
		if (graph == null || graph.length == 0) {
			return true;
		}
		map = new HashMap<>();
		getGraph(graph);
		color = new boolean[N + 1];
		marked = new boolean[N + 1];

		for (int i : map.keySet()) {
			if (!marked[i]) {
				dfs(i);
			}
		}
		boolean result = isBipartite;
		isBipartite = true;
		return result;
	}

	private static void getGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			int[] temp = graph[i];
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
	}

	public static void dfs(int s) {
		marked[s] = true;
		if (map.containsKey(s)) {
			for (int i : map.get(s)) {
				if (!marked[i]) {
					color[i] = !color[s];
					dfs(i);
				} else if (color[s] == color[i]) {
					isBipartite = false;
				}
			}
		}
	}

	public static void main(String[] args) {
	int N =4;
	int[][] graph = {{1,2},{1,3},{2,4}};
	System.out.println(possibleBipartition(N, graph));

	}

}
