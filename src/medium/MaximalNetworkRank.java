package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank {
	
	public int maximalNetworkRank(int n, int[][] roads) {
		if (roads == null || roads.length == 0) {
			return 0;
		}
		Map<Integer, Set<Integer>> map = new HashMap();

		for (int[] i : roads) {
			int to = i[0];
			int from = i[1];
			if (!map.containsKey(to)) {
				Set<Integer> set = new HashSet();
				set.add(from);
				map.put(to, set);
			} else {
				map.get(to).add(from);
			}
			if (!map.containsKey(from)) {
				Set<Integer> set = new HashSet();
				set.add(to);
				map.put(from, set);
			} else {
				map.get(from).add(to);
			}
		}

		int result = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (map.containsKey(i) && map.containsKey(j)) {
					int one = map.get(i).size();
					int two = map.get(j).size();
					int sum = one + two;
					Set<Integer> set = map.get(i);
					if (set.contains(j)) {
						sum = sum - 1;
					}
					result = Math.max(result, sum);
				}
			}
		}
		return result;
	}
}
