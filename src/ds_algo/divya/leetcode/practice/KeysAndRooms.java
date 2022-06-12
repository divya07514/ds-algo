package ds_algo.divya.leetcode.practice;

import java.util.List;

public class KeysAndRooms {

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean[] marked = new boolean[n];
		dfs(0, marked, rooms);
		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				return false;
			}
		}
		return true;
	}

	public static void dfs(int s, boolean[] marked, List<List<Integer>> rooms) {
		marked[s] = true;
		for (int i : rooms.get(s)) {
			if (!marked[i]) {
				dfs(i, marked, rooms);
			}
		}
	}

}
