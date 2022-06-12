package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[] isVisited = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		permute(result, list, isVisited, nums);
		return result;

	}

	private static void permute(List<List<Integer>> result, List<Integer> list, boolean[] isVisited, int[] nums) {
		if (list.size() == nums.length) {
			List<Integer> temp = new ArrayList<Integer>(list);
			result.add(temp);
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!isVisited[i]) {
					isVisited[i] = true;
					list.add(nums[i]);
					permute(result, list, isVisited, nums);
					list.remove(list.size() - 1);
					isVisited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };
		System.out.println(permute(nums));
	}
}
