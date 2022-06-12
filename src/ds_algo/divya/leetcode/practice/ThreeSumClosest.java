package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
		Map<Integer, Integer> map = new TreeMap<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[left] + nums[i] + nums[right];
				int diff = Math.abs(target - sum);
				map.put(diff, sum);
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}

		int result = 0;
		for (int i : map.keySet()) {
			result = map.get(i);
			break;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(threeSumClosest(nums, target));
	}

}
