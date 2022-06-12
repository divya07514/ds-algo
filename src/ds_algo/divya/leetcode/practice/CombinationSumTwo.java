package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumTwo {

	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		int index = 0;
		int current = 0;
		List<Integer> list = new ArrayList<>();
		Set<String> marked = new HashSet<>();
		sum(index, current, target, nums, list, result, marked);
		return result;
	}

	public static void sum(int index, int current, int target, int[] nums, List<Integer> list, List<List<Integer>> result,Set<String> marked) {

		if (current == target) {
			String key = list.toString();
			if (marked.contains(key)) {
				return;
			}
			List<Integer> temp = new ArrayList<>(list);
			result.add(temp);
			marked.add(key);
			return;
		}
		if (index >= nums.length) {
			return;
		}
		if (current > target) {
			return;
		}
		current = current + nums[index];
		list.add(nums[index]);
		sum(index + 1, current, target, nums, list, result, marked);
		int remove = list.remove(list.size() - 1);
		current = current - remove;
		sum(index + 1, current, target, nums, list, result, marked);
	}

	public static void main(String[] args) {
		int[] nums = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(combinationSum2(nums, target));
	}

}
