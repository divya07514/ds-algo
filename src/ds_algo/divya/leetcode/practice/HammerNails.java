package ds_algo.divya.leetcode.practice;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HammerNails {

	public static int solution(int[] nums, int Y) {
		int N = nums.length;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>((a, b) -> b - a);
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		List<Integer> list = map.values().stream().collect(Collectors.toList());
		if (list.size() == 1) {
			return list.get(0);
		}
		int result = list.get(0);
		int longer = 0;
		for (int j = 0; j < list.size(); j++) {
			int count = 0;
			if (Y < longer) {
				count = Y + list.get(j);
			} else {
				count = longer + list.get(j);
			}
			if (result < count) {
				result = count;
			}
			longer += list.get(j);
		}
		return result;

	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 3, 3, 3, 4, 5, 5, 5, 5 };
		System.out.println(solution(nums, 5));
	}

}
