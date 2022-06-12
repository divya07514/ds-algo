package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

	public static int findTargetSumWays(int[] nums, int s) {

		int index = 0;
		int current = 0;
		Map<String, Integer> memo = new HashMap<>();
		int result = dfs(index, current, s, nums, memo);
		return result;
	}

	public static int dfs(int index, int current, int s, int[] nums, Map<String, Integer> map) {

		if (index >= nums.length && current != s) {
			return 0;
		}
		if (index == nums.length && current == s) {
			return 1;
		}

		String key = index + "," + current;
		if (map.containsKey(key)) {
			return map.get(key);
		}

		int inclusive = dfs(index + 1, current + nums[index], s, nums, map);
		int exclusive = dfs(index + 1, current - nums[index], s, nums, map);
		map.put(key, inclusive + exclusive);
		return map.get(key);

	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int s = 3;
		System.out.println(findTargetSumWays(nums, s));
	}

}
