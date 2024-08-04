package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(candidates, target, 0, result, new ArrayList<Integer>());
		return result;
	}

	private static void helper(int[] candidates, int target, int startId, List<List<Integer>> res, List<Integer> curRes) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(curRes));
		} else {
			for (int i = startId; i < candidates.length && candidates[i] <= target; i++) {
				if (i > startId && candidates[i] == candidates[i - 1]) {
					continue;
				}
				curRes.add(candidates[i]);
				helper(candidates, target - candidates[i], i + 1, res, curRes);
				curRes.remove(curRes.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2 };
		int target = 4;
		System.out.println(combinationSum2(nums, target));

	}

}
