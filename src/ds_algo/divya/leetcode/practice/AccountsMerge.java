package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This question reduces to finding connected components in a graph.
 *
 */
public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		Map<String, Set<String>> map = new HashMap<>();
		Map<String, String> emails = new HashMap<>();

		for (List<String> list : accounts) {
			String name = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				if (!map.containsKey(list.get(i))) {
					map.put(list.get(i), new HashSet<>());
				}
				emails.put(list.get(i), name);
				if (i == 1) {
					continue;
				}
				// keep a undirected graph.
				map.get(list.get(i)).add(list.get(i - 1));
				map.get(list.get(i - 1)).add(list.get(i));
			}
		}

		List<List<String>> result = new ArrayList<>();
		Set<String> marked = new HashSet<>();

		for (String s : emails.keySet()) {
			List<String> list = new ArrayList<>();
			if (marked.add(s)) {
				dfs(map, s, list, marked);
				Collections.sort(list);
				list.add(0, emails.get(s));
				result.add(list);
			}
		}
		return result;
	}

	public void dfs(Map<String, Set<String>> map, String s, List<String> list, Set<String> marked) {
		list.add(s);
		for (String i : map.get(s)) {
			if (marked.add(i)) {
				dfs(map, i, list, marked);
			}
		}
	}
}
