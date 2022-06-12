package ds_algo.divya.leetcode.practice;

public class SubArrayProductLessThanK {

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return 0;
		}
		int count = 0;
		int product = 1;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			product = product * nums[right];
			while (product >= k) {
				product = product / nums[left];
				left++;
			}
			count = count + right - left + 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 5, 2, 6 };
		int k = 100;
		System.out.println(numSubarrayProductLessThanK(nums, k));

	}

}
