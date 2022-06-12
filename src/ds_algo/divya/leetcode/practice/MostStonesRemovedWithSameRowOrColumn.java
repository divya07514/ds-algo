package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
	
	public static int removeStones(int[][] stones) {
		if (stones == null || stones.length == 0) {
			return 0;
		}
		if (stones.length == 1) {
			return 0;
		}
		Set<int[]> marked = new HashSet<>();
		int connected = 0;
		for (int[] src : stones) {
			if (!marked.contains(src)) {
				dfs(src, marked, stones);
				connected++;
			}
		}
		return stones.length - connected;
	}

	public static void dfs(int[] src, Set<int[]> marked, int[][] stones) {
		marked.add(src);
		for (int[] i : stones) {
			if (!marked.contains(i)) {
				if (src[0] == i[0] || src[1] == i[1]) {
					dfs(i, marked, stones);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
		System.out.println(removeStones(stones));
	}

}
