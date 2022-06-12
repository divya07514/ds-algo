package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIncrementToMakeArrayUnique {

	/**
	 * Self implemented solution. gives time limit exceeded.
	 * 
	 * @param nums
	 * @return
	 */
	public static int minIncrementForUnique_tle(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		int result = 0;
		int[] keys = new int[map.keySet().size()];
		int index = 0;
		for (int i : map.keySet()) {
			keys[index++] = i;
		}
		for (int key : keys) {
			if (map.get(key) > 1) {
				int value = map.get(key);
				while (value != 1) {
					int count = 1;
					int current = key + 1;
					while (map.containsKey(current)) {
						current = current + 1;
						count++;
					}
					map.put(current, 1);
					result = result + count;
					value--;
					System.out.print(result + " ");
				}
			}
		}
		System.out.println();
		System.out.println(map);
		return result;
	}

	/**
	 * Self implemented solution.
	 * @param nums
	 * @return
	 */
	public static int minIncrementForUnique(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		int result = 0;
		int[] keys = new int[map.keySet().size()];
		int index = 0;
		for (int i : map.keySet()) {
			keys[index++] = i;
		}
		int lastGeneratedNumber = 0;
		for (int key : keys) {
			if (map.get(key) > 1) {
				int value = map.get(key);
				while (value != 1) {
					int count = 1;
					int current = key + 1;
					if (lastGeneratedNumber != 0) {
						if(key < lastGeneratedNumber) {
							count = lastGeneratedNumber - key + 1;
							current = 1 + lastGeneratedNumber;
						}else {
							count = 1;
							current = key + 1;
						}
					}
					if (map.containsKey(current)) {
						while (map.containsKey(current)) {
							current = current + 1;
							count++;
						}
					}

					map.put(current, 1);
					lastGeneratedNumber = current;
					result = result + count;
					value--;
					System.out.print(result + " ");
				}
			}
		}
		System.out.println();
		System.out.println(map);
		return result;

	}

	public static void main(String[] args) {
		int[] nums = { 14, 4, 5, 14, 13, 14, 10, 17, 2, 12, 2, 14, 7, 13, 14, 13, 4, 16, 4, 10 };
		System.out.println(minIncrementForUnique(nums));
		System.out.println();
		System.out.println(minIncrementForUnique_tle(nums));

	}

}
