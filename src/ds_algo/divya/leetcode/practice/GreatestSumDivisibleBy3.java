package ds_algo.divya.leetcode.practice;

public class GreatestSumDivisibleBy3 {

	public static int maxSumDivThree(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		if(sum%3==0) {
			return sum;
		}
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int temp = sum - nums[i];
			if (temp % 3 == 0) {
				max = Math.max(max, temp);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 2,6,2,2,7};
		System.out.println(maxSumDivThree(nums));
	}

}
