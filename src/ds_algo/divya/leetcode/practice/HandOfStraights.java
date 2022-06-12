package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights {

	/**
	 * Self implemented solution
	 * @param hand
	 * @param W
	 * @return
	 */
	public static boolean isNStraightHand(int[] hand, int W) {
		Arrays.sort(hand);
		if (hand.length % W != 0) {
			return false;
		}
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i : hand) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		List<List<Integer>> list = new ArrayList<>();
		while (!map.keySet().isEmpty()) {
			int counter = 1;
			List<Integer> temp = new ArrayList<>();
			List<Integer> processed = new ArrayList<>();
			for (int i : map.keySet()) {
				processed.add(i);
				temp.add(i);
				while (counter < W) {
					int next = i + 1;
					if (map.containsKey(next)) {
						processed.add(next);
						i = next;
						counter++;
						temp.add(next);
					}else {
						return false;
					}
				}
				if (counter == W) {
					list.add(temp);
					break;
				}
			}
			for (int i : processed) {
				map.put(i, map.get(i) - 1);
				if (map.get(i) == 0) {
					map.remove(i);
				}
			}

		}
		System.out.println(list);
		for (List<Integer> temp : list) {
			if (temp.size() != W) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] hand = { 8,10,12};
		int W = 3;
		System.out.println(isNStraightHand(hand, W));
	}

}
