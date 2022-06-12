package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class MissingElementInSortedArray {
	/**
	 * Self implemented solution. Times out.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */

	public static int missingElement_tle(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		int generated = 0;
		for (int i = 0; i < nums.length; i++) {
			if (k == 0) {
				return generated;
			}
			generated = nums[i] + 1;
			if (set.contains(generated)) {
				continue;
			} else {
				set.add(generated);
				k--;
				while (!set.contains(generated + 1) && k > 0) {
					generated = generated + 1;
					k--;
				}
			}

		}
		return generated;
	}

	public static int missingElement(int[] nums, int k) {
		int n = nums.length;

		if (k > missing(n - 1, nums))
			return nums[n - 1] + k - missing(n - 1, nums);

		int left = 0, right = n - 1, pivot;

		while (left != right) {
			pivot = left + (right - left) / 2;
			int missing = missing(pivot, nums);
			if ( missing < k) {
				left = pivot + 1;
			}
			else {
				right = pivot;
			}
		}

		return nums[left - 1] + k - missing(left - 1, nums);
	}

	public static int missing(int idx, int[] nums) {
		return nums[idx] - nums[0] - idx;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 7, 9, 10 };
		int k = 3;
		System.out.println(missingElement_tle(nums, k));
		System.out.println(missingElement(nums, k));

	}

}
