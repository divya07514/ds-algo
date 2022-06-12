package ds_algo.divya.leetcode.practice;

public class PeakElement {

	static int peak = 0;

	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int lo = 0;
		int hi = nums.length - 1;
		int n = nums.length;
		search(lo, hi, nums, n);
		int result = peak;
		peak = 0;
		return result;
	}

	public static void search(int lo, int hi, int[] nums, int n) {
		int mid = (hi + lo) / 2;
		if (lo > hi) {
			return;
		}
		if (mid - 1 >= 0 && mid + 1 < n) {
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				peak = mid;
				return;
			}
		}
		if (mid == n - 1 && mid - 1 >= 0 && nums[mid] > nums[mid - 1]) {
			peak = mid;
		}
		search(lo, mid - 1, nums, n);
		search(mid + 1, hi, nums, n);
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println(findPeakElement(nums));
	}

}
