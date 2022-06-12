package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}
		Map<String, Integer> map = new LinkedHashMap<>();
		List<TreeNode> result = new ArrayList<>();
		dfs(root, map, result);
		return result;
	}

	public String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
		if (root == null) {
			return "";
		}
		String left = dfs(root.left, map, result);
		String right = dfs(root.right, map, result);
		String key = root.val + "#" + left + "#" + right;
		if (!map.containsKey(key)) {
			map.put(key, 1);
		} else {
			map.put(key, map.get(key) + 1);
		}
		if (map.get(key) == 2) {
			result.add(root);
		}
		return key;
	}
}
