package ds_algo.divya.leetcode.practice;

public class HouseRobber {

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int one = nums[0];
		int two = Math.max(nums[1], nums[0]);
		for (int i = 2; i < nums.length; i++) {
			int temp = Math.max(nums[i] + one, two);
			one = two;
			two = temp;
		}
		return two;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
	}

}
