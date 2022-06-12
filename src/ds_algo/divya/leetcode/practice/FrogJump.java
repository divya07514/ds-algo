package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {

	/**
	 * Self implemented solution
	 * 
	 * @param stones
	 * @return
	 */
	public static boolean canCross(int[] stones) {

		if (stones[1] != 1) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i < stones.length; i++) {
			map.put(stones[i], i);
		}

		Map<String, Boolean> memo = new HashMap<>();
		int index = 0;
		int jump = 1;

		boolean result = dfs(index, jump, stones, map, memo);
		return result;
	}

	private static boolean dfs(int index, int jump, int[] stones, Map<Integer, Integer> map,
			Map<String, Boolean> memo) {

		if (index >= stones.length) {
			return false;
		}
		if (index == stones.length - 1) {
			return true;
		}
		String key = index + ", " + jump;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		boolean less = false;
		boolean same = false;
		boolean more = false;

		if (jump - 1 > 0) {
			int next = (jump - 1) + stones[index];
			if (map.containsKey(next)) {
				less = dfs(map.get(next), jump - 1, stones, map, memo);
			}
		}

		if (jump > 0) {
			int next = jump + stones[index];
			if (map.containsKey(next)) {
				same = dfs(map.get(next), jump, stones, map, memo);
			}
		}

		if (jump + 1 > 0) {
			int next = jump + 1 + stones[index];

			if (map.containsKey(next)) {
				more = dfs(map.get(next), jump + 1, stones, map, memo);
			}
		}

		boolean result = less || same || more;
		memo.put(key, result);
		return memo.get(key);
	}

	public static void main(String[] args) {
		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
		System.out.println(canCross(stones));
	}

}
