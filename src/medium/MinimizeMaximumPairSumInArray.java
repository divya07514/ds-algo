package medium;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

	public static int minPairSum(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = 0;
		Arrays.sort(nums);

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			int sum = nums[i] + nums[j];
			max = Math.max(max, sum);
			i++;
			j--;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = {3,5,4,2,4,6};
		System.out.println(minPairSum(nums));

	}

}
