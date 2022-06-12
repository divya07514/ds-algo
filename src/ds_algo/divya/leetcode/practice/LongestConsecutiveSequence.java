package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int count = 1;
		int max = 1;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		while (!set.isEmpty()) {
			int min = getMin(set);
			if (set.contains(min + 1)) {
				while (set.contains(min + 1)) {
					int current = min;
					count = count + 1;
					max = Math.max(count, max);
					set.remove(current);
					min = min + 1;
				}
			} else {
				count=1;
				set.remove(min);
			}
		}
		return max;
	}

	public static int getMin(Set<Integer> set) {
		int min = Integer.MAX_VALUE;
		for (int i : set) {
			min = Math.min(min, i);
		}
		return min;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
		System.out.println(longestConsecutive(nums));
	}

}
