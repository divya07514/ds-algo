package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarityII {

	public boolean areSentencesSimilarTwo(String[] one, String[] two, List<List<String>> pairs) {

		if (one.length != two.length) {
			return false;
		}
		Map<String, List<String>> map = new HashMap();
		for (List<String> l : pairs) {
			String a = l.get(0);
			String b = l.get(1);
			if (!map.containsKey(a)) {
				List<String> list = new ArrayList();
				list.add(b);
				map.put(a, list);
			} else {
				map.get(a).add(b);
			}
			if (!map.containsKey(b)) {
				List<String> list = new ArrayList();
				list.add(a);
				map.put(b, list);
			} else {
				map.get(b).add(a);
			}
		}

		for (int i = 0; i < one.length; i++) {
			if (one[i].equals(two[i])) {
				continue;
			} else {
				boolean check = bfs(one[i], two[i], map);
				if (!check) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean bfs(String src, String dest, Map<String, List<String>> map) {
		LinkedList<String> q = new LinkedList();
		Set<String> marked = new HashSet();
		q.add(src);
		marked.add(src);
		while (!q.isEmpty()) {
			String temp = q.poll();
			if (!map.containsKey(temp)) {
				continue;
			}
			for (String s : map.get(temp)) {
				if (s.equals(dest)) {
					return true;
				}
				if (!marked.contains(s)) {
					marked.add(s);
					q.add(s);
				}
			}
		}
		return false;
	}
}
