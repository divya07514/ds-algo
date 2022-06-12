package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		int index = 0;
		sets(result, list, nums, index);
		return result;
	}

	private static void sets(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
		if (index == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		list.add(nums[index]);
		sets(result, list, nums, index + 1);
		list.remove(list.size() - 1);
		sets(result, list, nums, index + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(subsets(nums));
	}

}
