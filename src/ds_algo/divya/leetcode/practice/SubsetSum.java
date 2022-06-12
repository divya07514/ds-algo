package ds_algo.divya.leetcode.practice;

public class SubsetSum {

	public static boolean subSet_recursive(int[] nums, int sum) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		return sum_recursive(nums, sum, n);
	}

	private static boolean sum_recursive(int[] nums, int sum, int n) {
		if (n == 0) {
			return false;
		}
		if (sum == 0) {
			return true;
		}
		if (nums[n - 1] > sum) {
			return sum_recursive(nums, sum, n - 1);
		}
		boolean include = sum_recursive(nums, sum - nums[n - 1], n - 1);
		boolean exclude = sum_recursive(nums, sum, n - 1);
		return include || exclude;
	}

	public static boolean subSet_memo(int[] nums, int sum) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		return sum_memo(nums, sum, n, dp);
	}

	private static boolean sum_memo(int[] nums, int sum, int n, boolean[][] dp) {
		if (n == 0) {
			return false;
		}
		if (sum == 0) {
			return true;
		}
		if (dp[n][sum]) {
			return dp[n][sum];
		}
		if (nums[n - 1] > sum) {
			dp[n][sum] = sum_memo(nums, sum, n - 1, dp);
			return dp[n][sum];
		}
		boolean include = sum_memo(nums, sum - nums[n - 1], n - 1, dp);
		boolean exclude = sum_memo(nums, sum, n - 1, dp);
		dp[n][sum] = include || exclude;
		return dp[n][sum];
	}

	public static boolean subSet_tabulation(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][target + 1];
		return sum_tabulation(nums, target, dp);
	}

	private static boolean sum_tabulation(int[] nums, int target, boolean[][] dp) {
		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] <= j) {
					boolean include = dp[i - 1][j - nums[i - 1]];
					boolean exclude = dp[i - 1][j];
					dp[i][j] = include || exclude;
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[nums.length][target];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 2 };
		int target = 9;
		System.out.println(subSet_recursive(nums, target));
		System.out.println(subSet_memo(nums, target));
		System.out.println(subSet_tabulation(nums, target));
	}

}
