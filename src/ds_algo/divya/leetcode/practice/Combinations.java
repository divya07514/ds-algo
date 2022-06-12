package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> result = new ArrayList<>();

		int[] nums = new int[n];
		int index = 0;
		for (int i = 1; i <= n; i++) {
			nums[index++] = i;
		}
		index = 0;
		List<Integer> list = new ArrayList<>();
		dfs(index, k, nums, list, result);
		return result;

	}

	public static void dfs(int i, int k, int[] nums, List<Integer> list, List<List<Integer>> result) {

		if (list.size() == k) {
			List<Integer> temp = new ArrayList<>(list);
			result.add(temp);
			return;
		}
		if (i >= nums.length) {
			return;
		}

		list.add(nums[i]);
		dfs(i + 1, k, nums, list, result);
		list.remove(list.size() - 1);
		dfs(i + 1, k, nums, list, result);
	}

	public static void main(String[] args) {
		int n = 20, k = 2;
		System.out.println(combine(n, k));

	}

}
