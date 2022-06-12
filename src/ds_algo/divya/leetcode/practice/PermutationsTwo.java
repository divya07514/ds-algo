package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsTwo {

	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		List<Integer> temp = new ArrayList<>();
		permute(nums, temp, result, map);
		return result;
	}

	public static void permute(int[] nums, List<Integer> temp, List<List<Integer>> result, Map<Integer, Integer> map) {
		if (temp.size() == nums.length) {
			List<Integer> list = new ArrayList<>(temp);
			result.add(list);
		} else {
			for (int i : map.keySet()) {
				if (map.get(i) - Collections.frequency(temp, i) > 0) {
					temp.add(i);
					permute(nums, temp, result, map);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,1,6};
		System.out.println(permuteUnique(nums));
	}

}
