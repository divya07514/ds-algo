package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class SubarraySumZero {

	public static boolean sum(int[] nums) {

		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum == 0 || nums[i] == 0 || set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 0, 1, 6 };
		System.out.println(sum(nums));
	}

}
