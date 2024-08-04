package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		if (k > n) {
			return new ArrayList();
		}
		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = i;
		}
		List<List<Integer>> result = new ArrayList();
		List<Integer> list = new ArrayList();
		int index = 1;
		dfs(index, nums, k, result, list);
		return result;
	}

	private void dfs(int index, int[] nums, int k, List<List<Integer>> result, List<Integer> list) {
		if (list.size() == k) {
			List<Integer> temp = new ArrayList(list);
			result.add(temp);
			return;
		}
		if (index >= nums.length) {
			return;
		}
		list.add(nums[index]);
		dfs(index + 1, nums, k, result, list);
		list.remove(list.size() - 1);
		dfs(index + 1, nums, k, result, list);
	}

}
