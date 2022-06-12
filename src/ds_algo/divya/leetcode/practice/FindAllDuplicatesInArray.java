package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

	public static List<Integer> findDuplicates(int[] nums) {

		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		for (int i = 0; i < nums.length; i++) {
			int temp = Math.abs(nums[i]) - 1;
			nums[temp] = nums[temp] * -1;
			System.out.print(nums[temp] + " ");
			if (nums[temp] > 0) {
				result.add(temp + 1);
			}
		}
		return result;

	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(nums));

	}

}
