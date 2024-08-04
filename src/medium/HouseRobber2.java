package medium;

import java.util.Arrays;

public class HouseRobber2 {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		if (n == 3) {
			return Math.max(nums[1], Math.max(nums[2], nums[0]));
		}
		int one = rob_house(nums, 0, n - 2);
		int two = rob_house(nums, 1, n - 1);
		return Math.max(one, two);
	}

	int rob_house(int[] nums, int start, int end) {
		int[] numsNew = Arrays.copyOfRange(nums, start, end + 1);
		int[] dp = new int[numsNew.length];
		dp[0] = numsNew[0];
		dp[1] = Math.max(numsNew[0], numsNew[1]);
		for (int i = 2; i < numsNew.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + numsNew[i]);
		}

		return dp[dp.length - 1];
	}

}
