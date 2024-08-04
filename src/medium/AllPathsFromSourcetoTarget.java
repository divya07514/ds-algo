package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DFS based solution
 * @author divya.thakur
 *
 */
public class AllPathsFromSourcetoTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		if (graph == null | graph.length == 0) {
			return new ArrayList();
		}

		Map<Integer, int[]> map = new HashMap();
		for (int i = 0; i < graph.length; i++) {
			map.put(i, graph[i]);
		}

		List<List<Integer>> result = new ArrayList();
		List<Integer> list = new ArrayList();
		list.add(0);
		dfs(0, map, list, result, graph.length);
		return result;
	}

	private void dfs(int s, Map<Integer, int[]> map, List<Integer> list, List<List<Integer>> result, int n) {
		if (map.containsKey(s)) {
			if (s == n - 1) {
				List<Integer> temp = new ArrayList(list);
				result.add(temp);
				return;
			}
			for (int i : map.get(s)) {
				list.add(i);
				dfs(i, map, list, result, n);
				list.remove(list.size() - 1);
			}
		}
	}
}
