package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// not full proof
public class TaskMaster_oracle {

	static boolean hasCycle;

	static int tasks(int n, List<Integer> a, List<Integer> b) {
		int res = 0;
		if (a.size() == 0 && b.size() == 0) {
			return n;
		}
		Map<Integer, List<Integer>> map = new HashMap();

		for (int i = 0; i < b.size(); i++) {
			int from = b.get(i);
			int to = a.get(i);
			if (!map.containsKey(from)) {
				List<Integer> list = new ArrayList();
				list.add(to);
				map.put(from, list);
			} else {
				map.get(from).add(to);
			}
		}
		boolean[] marked = new boolean[n + 1];
		boolean[] stack = new boolean[n + 1];
		for (int j = 1; j <= n; j++) {
			boolean[] onStack = new boolean[n + 1];
			hasCycle = false;
			if (!marked[j]) {
				dfs(j, stack, onStack, marked, map);
				if (hasCycle) {
					int count = 0;
					for (int i = 0; i < onStack.length; i++) {
						if (onStack[i] == true) {
							count++;
						}
					}
					res = res + count - 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == true) {
				count++;
			}
		}
		res = res + count;

		return res;
	}

	private static void dfs(int s, boolean[] stack, boolean[] onStack, boolean[] marked,
			Map<Integer, List<Integer>> map) {
		marked[s] = true;
		onStack[s] = true;
		if (map.containsKey(s)) {
			for (int i : map.get(s)) {
				if (!marked[i]) {
					dfs(i, stack, onStack, marked, map);
				} else if (onStack[i]) {
					hasCycle = true;
					return;
				}
			}
		}
		stack[s] = true;
		onStack[s] = false;
	}

	public static void main(String[] args) {
		int[] a = {1 };
		int[] b = {2 };
		List<Integer> one = new ArrayList<>();
		for (int i : a) {
			one.add(i);
		}
		List<Integer> two = new ArrayList<>();
		for (int i : b) {
			two.add(i);
		}
		System.out.println(tasks(2, one, two));
	}

}
