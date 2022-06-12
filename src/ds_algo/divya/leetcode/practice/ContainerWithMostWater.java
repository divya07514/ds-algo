package ds_algo.divya.leetcode.practice;

public class ContainerWithMostWater {

	public static int maxArea(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			result = Math.max(result, Math.min(nums[left], nums[right]) * (right - left));
			if (nums[left] < nums[right]) {
				left++;
			} else {
				right--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7 };
		System.out.println(maxArea(height));
	}

}
