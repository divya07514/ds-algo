package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
	
	static int result;

	public static int minReorder(int n, int[][] connections) {
		result = 0;
		List<Integer>[] incoming = new ArrayList[n];
		List<Integer>[] outgoing = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			incoming[i] = new ArrayList<>();
			outgoing[i] = new ArrayList<>();
		}

		for (int i = 0; i < connections.length; i++) {
			int[] temp = connections[i];
			int one = temp[0];
			int two = temp[1];

			incoming[two].add(one);
			outgoing[one].add(two);
		}

		boolean[] marked = new boolean[n];

		dfs(0, marked, incoming, outgoing);

		return result;
	}

	public static void dfs(int s, boolean[] marked, List<Integer>[] incoming, List<Integer>[] outgoing) {
		marked[s] = true;
		for (int i : outgoing[s]) {
			if (!marked[i]) {
				result++;
				dfs(i, marked, incoming, outgoing);
			}
		}

		for (int i : incoming[s]) {
			if (!marked[i]) {
				dfs(i, marked, incoming, outgoing);
			}
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
		System.out.println(minReorder(n, connections));
	}

}
