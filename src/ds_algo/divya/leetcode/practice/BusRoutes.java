package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BusRoutes {

	/**
	 * Self implemented solution. IN this implementation, Bus route are equivalent
	 * to nodes of a graph. AS a result, it becomes time consuming to create a build
	 * graph.
	 * 
	 * @param grid
	 * @param source
	 * @param target
	 * @return
	 */
	public static int numBusesToDestination_TLE(int[][] grid, int source, int target) {
		if (source == target) {
			return 0;
		}
		Map<Integer, List<Integer>> map = graph(grid);
		LinkedList<Integer> q = new LinkedList<>();
		q.add(source);
		int result = 1;
		Set<Integer> marked = new HashSet<>();
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int temp = q.poll();
				marked.add(temp);
				for (int i : map.get(temp)) {
					if (!marked.contains(i)) {
						if (i == target) {
							return result;
						}
						q.add(i);
					}
				}
				qs--;
			}
			result = result + 1;
		}
		return -1;
	}

	public static Map<Integer, List<Integer>> graph(int[][] grid) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] temp : grid) {
			for (int i = 0; i < temp.length; i++) {
				for (int j = i + 1; j < temp.length; j++) {
					int s = temp[i];
					int d = temp[j];
					if (!map.containsKey(s)) {
						List<Integer> list = new ArrayList<>();
						list.add(d);
						map.put(s, list);
					} else {
						map.get(s).add(d);
					}
					if (!map.containsKey(d)) {
						List<Integer> list = new ArrayList<>();
						list.add(s);
						map.put(d, list);
					} else {
						map.get(d).add(s);
					}
				}
			}
		}
		return map;
	}

	/**
	 * Leetcode solution. For each of the bus stop, we maintain all the buses (bus
	 * routes) that go through it. To do that, we use a HashMap, where bus stop
	 * number is the key and all the buses (bus routes) that go through it are added
	 * to an ArrayList.
	 * 
	 * @param routes
	 * @param S
	 * @param T
	 * @return
	 */
	public static int numBusesToDestination(int[][] routes, int S, int T) {
		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Integer> q = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int ret = 0;

		if (S == T)
			return 0;

		for (int i = 0; i < routes.length; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
				buses.add(i);
				map.put(routes[i][j], buses);
			}
		}

		q.offer(S);
		while (!q.isEmpty()) {
			int len = q.size();
			ret++;
			for (int i = 0; i < len; i++) {
				int cur = q.poll();
				ArrayList<Integer> buses = map.get(cur);
				for (int bus : buses) {
					if (visited.contains(bus)) {
						continue;
					}
					visited.add(bus);
					for (int j = 0; j < routes[bus].length; j++) {
						if (routes[bus][j] == T) {
							return ret;
						}
						q.offer(routes[bus][j]);
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
		int source = 1;
		int target = 6;
		System.out.println(numBusesToDestination_TLE(routes, source, target));
		System.out.println(numBusesToDestination(routes, source, target));
	}

}
