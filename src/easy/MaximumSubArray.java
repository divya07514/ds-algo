package easy;

public class MaximumSubArray {

	public static int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			sum = sum + i;
			max = Math.max(sum, max);
			if (sum < 0) {
				sum = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {

		int[] nums = { -5 };
		System.out.println(maxSubArray(nums));
	}

}
