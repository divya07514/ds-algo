package ds_algo.divya.leetcode.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PartitionEqualSubsetSum {

	static int[][] dp;

	public static boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int s1 = 0;
		int s2 = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			s1 = s1 + nums[i];
		}
		if (s1 % 2 == 1) {
			return false;
		}
		int half = s1 / 2;
		dp = new int[nums.length][half + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		// return partition_dp(nums, half, index);
		return partition_brute_force(nums, s1, s2, index);
	}


	private static boolean partition_dp(int[] nums, int half, int index) {
		if (index >= nums.length) {
			return false;
		}
		if (half < 0) {
			return false;
		}
		if (half == 0) {
			return true;
		}
		if (dp[index][half] != -1) {
			return dp[index][half] == 1;
		}
		dp[index][half] = (partition_dp(nums, half - nums[index], index + 1) || partition_dp(nums, half, index + 1)) ? 1
				: 0;
		return dp[index][half] == 1;
	}

	private static boolean partition_brute_force(int[] nums, int s1, int s2, int index) {
		if (index == nums.length && s1 != s2) {
			return false;
		}
		if (s1 == s2) {
			return true;
		}
		s2 = s2 + nums[index];
		s1 = s1 - nums[index];
		boolean ans = partition_brute_force(nums, s1, s2, index + 1);
		if (ans) {
			return true;
		} else {
			s2 = s2 - nums[index];
			s1 = s1 + nums[index];
			return partition_brute_force(nums, s1, s2, index + 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5 };
		
	}
}
