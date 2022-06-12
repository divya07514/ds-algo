package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumLengthOfPairChain {

	public static int findLongestChain(int[][] pairs) {

		if (pairs == null || pairs.length == 0) {
			return 0;
		}

		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		Map<Integer, Integer> map = new HashMap<>();
		int index = 0;
		int prevMax = Integer.MIN_VALUE;
		int result = dfs(index, prevMax, pairs, map);
		return result;
	}

	public static int dfs(int index, int prevMax, int[][] pairs, Map<Integer, Integer> map) {
		if (index >= pairs.length) {
			return 0;
		}
		if (map.containsKey(index)) {
			return map.get(index);
		}
		int include = 0;
		int exclude = 0;
		if (pairs[index][0] > prevMax) {
			include = 1 + dfs(index + 1, pairs[index][1], pairs, map);
		}
		exclude = dfs(index + 1, prevMax, pairs, map);
		int max = Math.max(include, exclude);
		map.put(index, max);
		return map.get(index);
	}

	public static void main(String[] args) {
		int[][] pairs = {{1,2}, {2,3}, {3,4}};
		System.out.println(findLongestChain(pairs));

	}

}
