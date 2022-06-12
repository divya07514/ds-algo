package ds_algo.divya.leetcode.practice;

public class FindMinimumInRotatedSortedArray {

	public static int findMin(int[] nums) {
		int length = nums.length;
		if (nums[0] < nums[length - 1]) {
			return nums[0];
		}
		int left = 0;
		int right = length - 1;
		int min = nums[0];
		while (left <= right) {
			int mid = left + (right - left) / 2;
			min = Math.min(min, Math.min(nums[mid], Math.min(nums[left], nums[right])));
			if (nums[left] <= nums[mid]) {
				left = mid + 1;
			} else  {
				right = mid - 1;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] nums = {6,5,4,3,2,1};
		System.out.println(findMin(nums));

	}

}
