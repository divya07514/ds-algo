package ds_algo.divya.leetcode.practice;

public class IncreasingripletSubsequence {

	/**
	 * Quadratic TC.. Uses dp table to store values. Works for Longest Increasing
	 * Subsequence.
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean increasingTriplet_dp(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int[] dp = new int[nums.length + 1];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int count = 0;
			for (int j = 0; j <= i; j++) {
				if (nums[i] > nums[j]) {
					count = Math.max(count, dp[j]);
				}
			}
			dp[i] = count + 1;
			if (dp[i] == 3) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean increasingTriplet_leetcode(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return false;
		}
		int min = nums[0];
		int mid = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			} else if (nums[i] < mid && nums[i] != min) {
				mid = nums[i];
			} else if (nums[i] > mid) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 11, 10, 5, 6, 2, 30 };
		System.out.println(increasingTriplet_dp(nums));
		System.out.println(increasingTriplet_leetcode(nums));
	}

}
