package ds_algo.divya.leetcode.practice;

public class CheckIfANumberIsMajorityElementInSortedArray {
	int first;
	int last;

	public boolean isMajorityElement(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		first = Integer.MAX_VALUE;
		last = Integer.MIN_VALUE;
		int n = nums.length;

		int left = 0;
		int right = n - 1;
		search(left, right, nums, target);
		if (first == Integer.MAX_VALUE && last == Integer.MIN_VALUE) {
			return false;
		}
		return (last - first + 1) > n / 2;

	}

	public void search(int left, int right, int[] nums, int target) {
		if (left > right) {
			return;
		}
		int mid = left + (right - left) / 2;
		if (mid + 1 < nums.length && nums[mid + 1] == target) {
			first = Math.min(first, mid + 1);
		}
		if (mid - 1 >= 0 && nums[mid - 1] == target) {
			last = Math.max(last, mid - 1);
		}
		if (mid == nums.length - 1 && nums[mid] == target) {
			last = nums.length - 1;
		}
		if (mid == 0 && nums[mid] == target) {
			first = 0;
		}
		search(left, mid - 1, nums, target);
		search(mid + 1, right, nums, target);
	}
}
