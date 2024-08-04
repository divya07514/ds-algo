package medium;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;
		if (nums == null || n == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;

		while (right < n) {
			sum = sum + nums[right];
			if (sum >= target) {
				while (sum >= target) {
					min = Math.min(right - left + 1, min);
					sum = sum - nums[left];
					left++;
				}
			}
			right++;
		}

		if (min == Integer.MAX_VALUE) {
			return 0;
		}
		return min;
	}

}
