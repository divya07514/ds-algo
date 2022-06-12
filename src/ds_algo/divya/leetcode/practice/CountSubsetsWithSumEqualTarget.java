package ds_algo.divya.leetcode.practice;

public class CountSubsetsWithSumEqualTarget {

	private static int subsets(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[][] dp = new int[n + 1][target + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] <= j) {
					int include = dp[i - 1][j - nums[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = include + exclude;
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][target];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3 };
		int target = 6;
		System.out.println(subsets(nums, target));
	}

}
