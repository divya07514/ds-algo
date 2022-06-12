package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < graph.length; i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j : graph[i]) {
				temp.add(j);
			}
			map.put(i, temp);
		}
		int n = graph.length-1;
		List<List<Integer>> result = new ArrayList<>();
		getPath(result, map,n);
		result.remove(result.size()-1);
		return result;
	}

	public static void getPath(List<List<Integer>> result, Map<Integer, List<Integer>> map,int n) {
			List<Integer> list = new ArrayList<>();
			dfs(0, list, map, result,n);
			result.add(list);
	}

	public static void dfs(int s, List<Integer> temp, Map<Integer, List<Integer>> map, List<List<Integer>> result,int n) {
		if (s==n) {
			temp.add(s);
			result.add(new ArrayList<>(temp));
			return;
		}
		temp.add(s);
		for (int i : map.get(s)) {
			List<Integer> p = new ArrayList<>(temp);
			dfs(i, p, map, result,n);
		}
	}

	public static void main(String[] args) {
		int[][] graph = {{3,1},{4,6,7,2,5},{4,6,3},{6,4},{7,6,5},{6},{7},{}};
		System.out.println(allPathsSourceTarget(graph));

	}

}
