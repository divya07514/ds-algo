package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

	public static int numSubseq(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mod = (int) 1e9 + 7;
		int result = 0;
		int[] pow = new int[nums.length];
		pow[0] = 1;
		// array to store powers of 2 
		for (int i = 1; i < nums.length; i++) {
			pow[i] = pow[i - 1] * 2 % mod;
		}
		Arrays.sort(nums);
		while (left <= right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else {
				result = (result + pow[right - left]) % mod;
				left++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,3,4,6,7};
		int target = 12;
		System.out.println(numSubseq(nums, target));
	}

}
