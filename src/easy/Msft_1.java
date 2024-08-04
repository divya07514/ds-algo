package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Msft_1 {

	static boolean valid;

	public static boolean solution(int n, int[] one, int[] two) {
		if (n == 0 || one.length == 0 || two.length == 0) {
			return true;
		}
		if (one.length == 0 || two.length == 0) {
			return false;
		}
		Map<Integer, List<Integer>> map = new HashMap();
		valid = true;
		for (int i = 0; i < one.length; i++) {
			int a = one[i];
			int b = two[i];
			if (!map.containsKey(a)) {
				List<Integer> list = new ArrayList();
				list.add(b);
				map.put(a, list);
			} else {
				map.get(a).add(b);
			}
			if (!map.containsKey(b)) {
				List<Integer> list = new ArrayList();
				list.add(a);
				map.put(b, list);
			} else {
				map.get(b).add(a);
			}
		}

		boolean[] marked = new boolean[n + 1];
		dfs(n, 1, marked, map, 1);
		if (!valid) {
			return false;
		}
		for (int i = 1; i < marked.length; i++) {
			if (!marked[i]) {
				return false;
			}
		}

		return true;
	}

	private static void dfs(int n, int start, boolean[] marked, Map<Integer, List<Integer>> map, int count) {
		if (marked[start]) {
			return;
		}
		if (start != count) {
			valid = false;
			return;
		}
		marked[start] = true;
		if (count == n) {
			return;
		}
		if (map.containsKey(start)) {
			for (int next : map.get(start)) {
				if (!marked[next]) {
					dfs(n, next, marked, map, count + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[] one = { 2, 4, 5, 3 };
		int[] two = { 3, 5, 6, 4 };
		System.out.println(solution(n, one, two));

	}

}