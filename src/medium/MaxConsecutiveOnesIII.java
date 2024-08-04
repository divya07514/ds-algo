package medium;

public class MaxConsecutiveOnesIII {
	public int longestOnes(int[] nums, int k) {
		int n = nums.length;

		if (nums == null || n == 0) {
			return 0;
		}

		if (k == n) {
			return n;
		}

		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;

		while (right < n) {
			if (nums[right] == 0) {
				k--;
			}
			while (k < 0) {
				if (nums[left] == 0) {
					k++;
				}
				left++;
			}
			max = Math.max(max, right - left + 1);
			right++;
		}
		return max;
	}
}
