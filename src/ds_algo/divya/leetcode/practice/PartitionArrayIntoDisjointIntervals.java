package ds_algo.divya.leetcode.practice;

public class PartitionArrayIntoDisjointIntervals {

	public static int partitionDisjoint(int[] nums) {

		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];

		int max = nums[0];
		for (int i = 0; i < n; i++) {
			max = Math.max(max, nums[i]);
			left[i] = max;
		}

		int min = nums[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			min = Math.min(min, nums[i]);
			right[i] = min;
		}

		for (int i = 1; i < n; i++) {
			if (left[i - 1] <= right[i]) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 6, 12 };
		System.out.println(partitionDisjoint(nums));

	}

}
