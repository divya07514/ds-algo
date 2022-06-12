package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class ThreeSumSmaller {

	public static int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					count = count + k - j;
					j++;
				} else {
					k--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {3,5,2,8,1};
		int target = 7;
		System.out.println(threeSumSmaller(nums, target));
	}

}
