package ds_algo.divya.leetcode.practice;

public class LargestRectangleInHistogram {

	/**
	 * Self Implemented solution.
	 * 
	 * @param nums
	 * @return
	 */
	public static int largestRectangleArea(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];

		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int start = i + 1;
			while (start < n && nums[start] > nums[i]) {
				count++;
				start++;
			}
			left[i] = count;
			count = 0;
		}
		count = 0;
		for (int i = 1; i < n; i++) {
			int start = i - 1;
			while (start >= 0 && nums[start] > nums[i]) {
				count++;
				start--;
			}
			right[i] = count;
			count = 0;
		}

		int area = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int leftVal = left[i];
			int rightVal = right[i];
			int total = leftVal + rightVal + 1;
			int temp = total * nums[i];
			area = Math.max(area, temp);
		}

		return area;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(nums));
	}

}
