package ds_algo.divya.leetcode.practice;

public class PartitionArrayForMaximumSum {

	public static int maxSumAfterPartitioning(int[] arr, int k) {
		Integer[] memo = new Integer[arr.length];
		return maxSumAfterPartitioning(arr, k, 0, memo);
	}

	private static int maxSumAfterPartitioning(int[] arr, int k, int i, Integer[] memo) {
		if (i == arr.length) {
			return 0;
		}
		if (memo[i] != null) {
			return memo[i];
		}

		int currMax = 0;
		int sumMax = 0;
		for (int j = 0; j < k; j++) {
			int to = i + j;
			if (to >= arr.length) {
				break;
			}
			currMax = Math.max(currMax, arr[to]);
			int left = currMax * (j + 1);
			int right = maxSumAfterPartitioning(arr, k, to + 1, memo);
			sumMax = Math.max(sumMax, (left + right));
		}
		return memo[i] = sumMax;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 15, 7, 4 };
		int k = 2;
		System.out.println(maxSumAfterPartitioning(nums, k));
	}

}
