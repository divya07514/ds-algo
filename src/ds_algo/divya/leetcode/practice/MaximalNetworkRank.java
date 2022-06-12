package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank {
	
	public static int maximalNetworkRank(int n, int[][] roads) {

		if (roads.length == 0) {
			return 0;
		}
		if (roads.length == 1) {
			return 1;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();

		for (int[] i : roads) {
			int one = i[0];
			int two = i[1];

			if (!map.containsKey(one)) {
				Set<Integer> set = new HashSet<>();
				set.add(two);
				map.put(one, set);
			} else {
				map.get(one).add(two);
			}

			if (!map.containsKey(two)) {
				Set<Integer> set = new HashSet<>();
				set.add(one);
				map.put(two, set);
			} else {
				map.get(two).add(one);
			}
		}

		List<Integer> list = new ArrayList<>(map.keySet());
		Comparator<Integer> c = (a, b) -> map.get(b).size() - map.get(a).size();
		Collections.sort(list, c);

		int result = 0;
		for (int i = 0; i < list.size() - 2; i++) {
			int one = list.get(i);
			for (int j = i + 1; j < list.size() - 1; j++) {
				int two = list.get(j);
				int max = map.get(one).size() + map.get(two).size();
				if (map.get(one).contains(two)) {
					max = max - 1;
				}
				result = Math.max(result, max);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
		System.out.println(maximalNetworkRank(n, roads));

	}

}
