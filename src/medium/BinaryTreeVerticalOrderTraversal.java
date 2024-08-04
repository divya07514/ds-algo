package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * for this question, we need to maintain both horizontal distance and depth of every node.
 * @author divya.thakur
 *
 */
public class BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList();
		}
		List<List<Integer>> result = new ArrayList();
		Map<Integer, List<int[]>> map = new TreeMap();
		int hd = 0;
		int depth = 0;
		traverse(hd, depth, map, root);
		Comparator<int[]> c = (a, b) -> a[0] - b[0];
		for (int i : map.keySet()) {
			List<int[]> temp = map.get(i);
			Collections.sort(temp, c);
			List<Integer> list = new ArrayList();
			for (int[] j : temp) {
				list.add(j[1]);
			}
			result.add(list);
		}

		return result;
	}

	private void traverse(int hd, int depth, Map<Integer, List<int[]>> map, TreeNode root) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(hd)) {
			map.put(hd, new ArrayList());
		}
		map.get(hd).add(new int[] { depth, root.val });
		traverse(hd - 1, depth + 1, map, root.left);
		traverse(hd + 1, depth + 1, map, root.right);
	}
}
