package ds_algo.divya.leetcode.practice;

public class SearchInRotatedSortedArray {

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (end + start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] >= nums[start]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target <= nums[end] && target > nums[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(search(nums, 2));
	}

}
