package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
	static boolean hasCycle = false;

	public static boolean canFinish(int numCourses, int[][] pre) {
		if (pre == null || pre.length == 0) {
			return true;
		}
		Map<Integer, List<Integer>> map = fillMap(pre);
		boolean[] marked = new boolean[numCourses];
		boolean[] onStack = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!marked[i]) {
				dfs(i, marked, onStack, map);
			}
		}
		boolean result = hasCycle;
		hasCycle = false;
		return !result ? true : false;
	}

	private static void dfs(int s, boolean[] marked, boolean[] onStack, Map<Integer, List<Integer>> map) {
		marked[s] = true;
		onStack[s] = true;
		if (map.containsKey(s)) {
			for (int i : map.get(s)) {
				if (!marked[i]) {
					dfs(i, marked, onStack, map);
				} else if (onStack[i]) {
					hasCycle = true;
				}
			}
		}
		onStack[s] = false;
	}

	private static Map<Integer, List<Integer>> fillMap(int[][] pre) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < pre.length; i++) {
			int one = pre[i][0];
			int two = pre[i][1];
			if (!map.containsKey(two)) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(one);
				map.put(two, temp);
			} else {
				map.get(two).add(one);
			}
		}
		return map;

	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] pre = { { 1, 0 }, { 0, 1 } };
		System.out.println(canFinish(numCourses, pre));

	}
}
