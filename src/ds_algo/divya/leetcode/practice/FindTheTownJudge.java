package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheTownJudge {

	public static int findJudge(int N, int[][] trust) {
		if (N == 1 && trust.length == 0) {
			return N;
		}
		if (N > 1 && trust.length == 0) {
			return -1;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < trust.length; i++) {
			int[] temp = trust[i];
			int one = temp[0];
			int two = temp[1];
			if (!map.containsKey(one)) {
				List<Integer> list = new ArrayList<>();
				list.add(two);
				map.put(one, list);
			} else {
				map.get(one).add(two);
			}
		}
		int ans = 0;
		boolean found = false;
		for (int key : map.keySet()) {
			List<Integer> list = map.get(key);
			for (int i : list) {
				if (!map.containsKey(i)) {
					ans = i;
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		System.out.println(map);
		for (int i = 1; i <= N; i++) {
			if (!map.containsKey(i) && i != ans) {
				return -1;
			} else {
				List<Integer> list = map.get(i);
				if (list!=null && !list.contains(ans)) {
					return -1;
				}
			}

		}
		return ans;
	}

	public static void main(String[] args) {
		int N = 4;
		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		System.out.println(findJudge(N, trust));

	}

}
