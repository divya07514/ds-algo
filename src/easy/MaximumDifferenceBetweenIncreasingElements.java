package easy;

public class MaximumDifferenceBetweenIncreasingElements {

	public static int maximumDifference(int[] nums) {

		int min = nums[0];
		int max = -1;

		for (int i = 0; i < nums.length; i++) {

			if (min >= nums[i]) {
				min = nums[i];
			} else {
				if (max < nums[i] - min) {
					max = nums[i] - min;
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = {1,5,2,10};
		System.out.println(maximumDifference(nums));

	}

}
