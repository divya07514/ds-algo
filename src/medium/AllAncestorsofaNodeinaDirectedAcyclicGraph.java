package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAncestorsofaNodeinaDirectedAcyclicGraph {
	Map<Integer, List<Integer>> map;

	public List<List<Integer>> getAncestors(int n, int[][] edges) {
		map = new HashMap();
		for (int[] i : edges) {
			int from = i[0];
			int to = i[1];
			if (!map.containsKey(from)) {
				List<Integer> list = new ArrayList();
				list.add(to);
				map.put(from, list);
			} else {
				map.get(from).add(to);
			}
		}

		Map<Integer, List<Integer>> paths = new HashMap();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(i)) {
				List<Integer> list = new ArrayList();
				boolean[] marked = new boolean[n];
				dfs(i, list, marked);
				paths.put(i, list);
			}
		}

		Map<Integer, List<Integer>> ancestor = new HashMap();

		for (int s : paths.keySet()) {
			List<Integer> list = paths.get(s);
			for (int i : list) {
				if (i == s)
					continue;
				if (!ancestor.containsKey(i)) {
					List<Integer> temp = new ArrayList();
					temp.add(s);
					ancestor.put(i, temp);
				} else {
					ancestor.get(i).add(s);
				}
			}
		}

		List<List<Integer>> result = new ArrayList();
		for (int i = 0; i < n; i++) {
			if (!ancestor.containsKey(i)) {
				result.add(new ArrayList());
				continue;
			}
			List<Integer> l = ancestor.get(i);
			Collections.sort(l);
			result.add(l);
		}

		return result;
	}

	private void dfs(int s, List<Integer> list, boolean[] marked) {
		marked[s] = true;
		list.add(s);
		if (map.containsKey(s)) {
			for (int i : map.get(s)) {
				if (!marked[i]) {
					dfs(i, list, marked);
				}
			}
		}
	}
}
