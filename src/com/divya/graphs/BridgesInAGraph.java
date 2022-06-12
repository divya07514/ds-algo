package com.divya.graphs;

import java.util.ArrayList;
import java.util.List;

public class BridgesInAGraph {

	static int id;
	static int[] ids;
	static int[] low;
	static boolean[] marked;

	private static List<List<Integer>> findBridges(int n, List<List<Integer>> graph) {
		id = 0;
		ids = new int[n];
		low = new int[n];
		marked = new boolean[n];
		int parent = -1;
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!marked[i]) {
				dfs(i, parent, result, graph);
			}
		}
		return result;
	}

	private static void dfs(int at, int parent, List<List<Integer>> result, List<List<Integer>> graph) {
		id++;
		marked[at] = true;
		ids[at] = id;
		low[at] = id;
		for (int to : graph.get(at)) {
			if (to == parent) {
				continue;
			}
			if (!marked[to]) {
				dfs(to, at, result, graph);
				low[at] = Math.min(low[at], low[to]);
				if (ids[at] < low[to]) {
					List<Integer> list = new ArrayList<>();
					list.add(at);
					list.add(to);
					result.add(list);
				}
			} else {
				low[at] = Math.min(low[at], ids[to]);
			}
		}
	}

	public static void main(String[] args) {

		int n = 9;
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 2, 5);
		addEdge(graph, 5, 6);
		addEdge(graph, 6, 7);
		addEdge(graph, 7, 8);
		addEdge(graph, 8, 5);

		List<List<Integer>> bridges = findBridges(n, graph);
		System.out.println(bridges);
	}

	public static void addEdge(List<List<Integer>> graph, int from, int to) {
		graph.get(from).add(to);
		graph.get(to).add(from);
	}

}
