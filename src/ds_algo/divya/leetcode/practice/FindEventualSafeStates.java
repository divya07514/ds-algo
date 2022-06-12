package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindEventualSafeStates {

	/**
	 * Cycle detection on a directed graph
	 * Contains code to check for cycle without have a static variable.
	 * @param graph
	 * @return
	 */
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return new ArrayList<>();
		}
		int n = graph.length;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			boolean[] marked = new boolean[n];
			boolean[] onStack = new boolean[n];
			List<Integer> stack = new LinkedList<>();
			dfs(i, marked, onStack, graph, stack);
			if (stack.isEmpty()) {
				result.add(i);
			}
		}
		return result;
	}

	public static void dfs(int s, boolean[] marked, boolean[] onStack, int[][] graph, List<Integer> stack) {
		marked[s] = true;
		onStack[s] = true;
		for (int i : graph[s]) {
			if (!marked[i]) {
				dfs(i, marked, onStack, graph, stack);
			} else if (onStack[i]) {
				stack.add(s);
			}
		}
		onStack[s] = false;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		System.out.println(eventualSafeNodes(graph));
	}

}
