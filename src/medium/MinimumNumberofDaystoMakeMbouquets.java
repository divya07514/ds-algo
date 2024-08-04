package medium;

public class MinimumNumberofDaystoMakeMbouquets {

	public int minDays(int[] nums, int m, int k) {
		int n = nums.length;
		if (nums == null || n == 0) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			max = Math.max(max, i);
		}
		int left = 1;
		int right = max;
		int result = -1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			boolean ans = canDo(mid, nums, m, k);
			if (ans) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	private boolean canDo(int mid, int[] nums, int m, int k) {
		boolean ans = false;
		int[] temp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= mid) {
				temp[i] = 1;
			}
		}
		int count = 0;
		int index = 0;
		int current = 0;
		while (index < temp.length) {
			if (temp[index] == 1) {
				current++;
				if (current == k) {
					count++;
					current = 0;
				}
			} else {
				current = 0;
			}
			index++;
		}
		return count >= m;
	}

}
