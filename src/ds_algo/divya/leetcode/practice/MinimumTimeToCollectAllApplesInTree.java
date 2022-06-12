package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTimeToCollectAllApplesInTree {

	public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] i : edges) {
			int from = i[0];
			int to = i[1];
			if (!map.containsKey(from)) {
				List<Integer> list = new ArrayList<>();
				list.add(to);
				map.put(from, list);
			} else {
				map.get(from).add(to);
			}
			if (!map.containsKey(to)) {
				List<Integer> list = new ArrayList<>();
				list.add(from);
				map.put(to, list);
			} else {
				map.get(to).add(from);
			}

		}
		boolean[] marked = new boolean[n];
		return dfs(0, 0, hasApple, marked, map);
	}

	public static int dfs(int src, int defaultCost, List<Boolean> hasApple, boolean[] marked, Map<Integer, List<Integer>> map) {
		if (marked[src]) {
			return 0;
		}
		marked[src] = true;
		int currentCost = 0;
		for (int i : map.get(src)) {
			currentCost = currentCost + dfs(i, 2, hasApple, marked, map);
		}
		if (currentCost == 0 && !hasApple.get(src)) {
			return 0;
		}
		return defaultCost + currentCost;
	}

	public static void main(String[] args) {
		int n = 7;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		boolean[] array = { false, false, true, false, true, true, false };
		List<Boolean> hasApple = new ArrayList<>();
		for (boolean b : array) {
			hasApple.add(b);
		}

		System.out.println(minTime(n, edges, hasApple));

	}

}
