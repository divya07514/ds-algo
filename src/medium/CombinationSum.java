package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return new ArrayList();
		}

		List<List<Integer>> result = new ArrayList();
		List<Integer> list = new ArrayList();
		int i = 0;
		int cs = 0;

		sum(i, cs, nums, list, result, target);
		return result;
	}

	private static void sum(int i, int cs, int[] nums, List<Integer> list, List<List<Integer>> result, int target) {
		if (cs == target) {
			List<Integer> temp = new ArrayList(list);
			result.add(temp);
			return;
		}
		if (cs > target) {
			return;
		}
		cs = cs + nums[i];
		list.add(nums[i]);
		sum(i, cs, nums, list, result, target);
		cs = cs - nums[i];
		list.remove(list.size() - 1);
		if (i + 1 < nums.length) {
			sum(i + 1, cs, nums, list, result, target);
		}
	}

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}

}
