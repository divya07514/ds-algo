package easy;

public class Leetcode1909 {

	public boolean canBeIncreasing(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int idx = 0;
		int count = 0;
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			if (nums[i] <= nums[i - 1]) {
				count++;
				idx = i - 1;
			}
		}
		if (count > 1) {
			return false;
		}
		if (count == 1) {
			if (idx == 0 || idx == nums.length - 2) {
				return true;
			}
			if (nums[idx + 1] > nums[idx - 1] || nums[idx + 2] > nums[idx]) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

}
