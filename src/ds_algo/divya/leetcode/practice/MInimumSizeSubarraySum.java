package ds_algo.divya.leetcode.practice;

public class MInimumSizeSubarraySum {

	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0 || s == 0) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int length = Integer.MAX_VALUE;
		int sum = 0;

		for (j = 0; j < nums.length; j++) {
			sum = sum + nums[j];
			while (sum >= s) {
				length = Math.min(j - i + 1, length);
				sum = sum - nums[i++];
			}
		}

		return (length != Integer.MAX_VALUE) ? length : 0;
	}

	public static void main(String[] args) {
		int s = 15;
		int[] nums = { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 };
		System.out.println(minSubArrayLen(s, nums));

	}

}
