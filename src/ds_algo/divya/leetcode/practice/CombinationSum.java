package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		if (nums.length == 1 && target != nums[0]) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 1 && target == nums[0]) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			result.add(list);
			return result;
		}
		List<Integer> list = new ArrayList<>();
		int index = 0;
		int current = 0;
		sum(index, current, target, nums, list, result);
		return result;
	}

	public static void sum(int index, int current, int target, int[] nums, List<Integer> list,
			List<List<Integer>> result) {
		if (index >= nums.length) {
			return;
		}
		if (current > target) {
			return;
		}
		if (current == target) {
			List<Integer> temp = new ArrayList<>(list);
			result.add(temp);
			return;
		}
		current = current + nums[index];
		list.add(nums[index]);
		sum(index, current, target, nums, list, result);
		int remove = list.remove(list.size() - 1);
		current = current - remove;
		sum(index + 1, current, target, nums, list, result);

	}

	static int[] memo;
	static int prev = 0;
	public static int combinationSum4( int target) {
		memo = new int[target + 1];
		Arrays.fill(memo, -1);
		int[] nums=  new int[]{1,2,4,6};
		int ans = findCombination(nums, target);
		return ans;
	}

	private static int findCombination(int[] nums, int target) {
		if (target == 0) {
			return 1;
		}
			
		if (memo[target] != -1) {
			return memo[target];
		}
			
		int count = 0;
		int num =0;
		for (int i=0;i<nums.length;i++) {
			 num = nums[i];
			if (target - num < 0) {
				break;
			}
			if(prev==4 && num==4) {
				System.out.println("prev");
				continue;
			}
			count = count + findCombination(nums, target - num);
		}
		prev = num;
		memo[target] = count;
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(combinationSum(nums, target));

		System.out.println(combinationSum4(6));
	}

}
