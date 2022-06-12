package ds_algo.divya.leetcode.practice;

public class MaximumLengthOfRepeatedSubarray {

	public static int findLength(int[] A, int[] B) {
		int r = A.length;
		int c = B.length;
		int[][] dp = new int[r + 1][c + 1];
		int max = 0;
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

	public static int minStartValue(int[] nums) {
		int sum = 0;
		int start = 1;
		int index = 0;
		for (; index < nums.length;) {
			if (index == 0) {
				sum = sum + nums[index] + start;
			} else {
				sum = sum + nums[index];
			}
			index++;
			if (sum < 1) {
				index = 0;
				sum = 0;
				start++;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 2, 1 };
		int[] B = { 3, 2, 1, 4 };
		System.out.println(findLength(A, B));

		int[] nums = { -3, 2, -3, 4, 2 };
		System.out.println(minStartValue(nums));
	}

}
