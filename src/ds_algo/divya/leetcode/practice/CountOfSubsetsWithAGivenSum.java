package ds_algo.divya.leetcode.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountOfSubsetsWithAGivenSum {

	private static int countSubsets(int[] nums, int sum) {
		int i = 0;
		Map<String, Integer> memo = new LinkedHashMap<String, Integer>();
		int res = count(nums, sum, i, memo);
		System.out.println(memo);
		return res;
	}

	private static int count(int[] nums, int sum, int i, Map<String, Integer> memo) {
		if (i == nums.length) {
			if (sum == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		String key = i+";"+sum;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int left = count(nums, sum - nums[i], i + 1, memo);
		int right = count(nums, sum, i + 1, memo);
		memo.put(key, left+right);
		return memo.get(key);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int sum = 10;
		System.out.println(countSubsets(nums, sum));
	}

}
