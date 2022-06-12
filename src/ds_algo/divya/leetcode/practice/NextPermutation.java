package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class NextPermutation {

	public static void nextPermutation(int[] nums) {
		if(nums==null || nums.length==0) {
			return;
		}
		boolean isReversed = true;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]<nums[i+1]) {
				isReversed = false;
				break;
			}
		}
		if(isReversed) {
			Arrays.sort(nums, 0, nums.length);
			return;
		}
		int i = nums.length - 1;
		while (i >= 1) {
			if (nums[i - 1] >= nums[i]) {
				i--;
			} else {
				i--;
				break;
			}
		}
		if (i < 0) {
			Arrays.sort(nums);
			return;
		}
		Arrays.sort(nums, i + 1, nums.length);
		int j = i + 1;
		while (j < nums.length) {
			if (nums[j] > nums[i]) {
				break;
			} else {
				j++;
			}
		}
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		//Arrays.sort(nums, i + 1, nums.length);
	}

	public static void main(String[] args) {
		int[] nums = {2,2,7,5,4,3,2,2,1};
		nextPermutation(nums);
		ArrayUtil.printArray(nums);
	}

}
