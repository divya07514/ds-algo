package easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {

	public static int largestPerimeter(int[] nums) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 2; i--) {
			int three = nums[i];
			int two = nums[i - 1];
			int one = nums[i - 2];
			if (two + one > three) {
				return one + two + three;
			}

		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = {2,1,2};
		System.out.println(largestPerimeter(nums));

	}

}
