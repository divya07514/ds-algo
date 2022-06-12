package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			int count = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					count = Math.max(count, dp[j]);
				}
			}
			dp[i] = count + 1;
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static int lengthOfLIS_memo(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		Map<String, Integer> map = new HashMap<>();
		int index = 0;
		int prevIndex = -1;
		int result = dfs(index, prevIndex, nums, map);
		return result;
	}

	public static int dfs(int index, int prevIndex, int[] nums, Map<String, Integer> map) {
		if (index >= nums.length) {
			return 0;
		}
		String key = index + ", " + prevIndex;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int include = 0;
		int exclude = 0;
		if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
			include = 1 + dfs(index + 1, index, nums, map);
		}
		exclude = dfs(index + 1, prevIndex, nums, map);
		int max = Math.max(include, exclude);
		map.put(key, max);
		return map.get(key);
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
		System.out.println(lengthOfLIS_memo(nums));
	}

}
