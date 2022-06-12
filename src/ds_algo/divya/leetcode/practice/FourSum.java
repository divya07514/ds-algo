package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	public static  List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int aindex = 0;
		while (nums.length - aindex >= 4) {
			if (aindex > 0 && nums[aindex] == nums[aindex - 1]) {
				aindex++;
				continue;
			}
			int bindex = aindex + 1;
			while (nums.length - bindex >= 3) {
				int cindex = bindex + 1;
				int dindex = nums.length - 1;
				while (cindex < dindex) {
					int sum = nums[aindex] + nums[bindex] + nums[cindex] + nums[dindex];
					if (sum == target) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[aindex]);
						list.add(nums[bindex]);
						list.add(nums[cindex]);
						list.add(nums[dindex]);
						result.add(list);
						cindex++;
						dindex--;
					} else if (sum < target) {
						cindex++;
					} else {
						dindex--;
					}
				}
				bindex++;
			}
			aindex++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {2,2,2,2};
		int target = 8;
		System.out.println(fourSum(nums, target));
	}
}
