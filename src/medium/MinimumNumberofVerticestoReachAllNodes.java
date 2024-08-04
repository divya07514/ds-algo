package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Look for nodes with indegree as 0.
 * @author divya.thakur
 *
 */
public class MinimumNumberofVerticestoReachAllNodes {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

		Map<Integer, List<Integer>> map = new HashMap();

		for (List<Integer> l : edges) {
			int from = l.get(0);
			int to = l.get(1);
			if (!map.containsKey(from)) {
				List<Integer> temp = new ArrayList();
				temp.add(to);
				map.put(from, temp);
			} else {
				map.get(from).add(to);
			}
		}

		List<Integer> result = new ArrayList();
		Set<Integer> set = new HashSet();
		for (int i : map.keySet()) {
			List<Integer> l = map.get(i);
			for (int j : l) {
				set.add(j);
			}
		}

		for (int i = 0; i < n; i++) {
			if (!set.contains(i)) {
				result.add(i);
			}
		}

		return result;
	}

}
