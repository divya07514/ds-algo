package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubtreeWithAllTheDeepestNodes {
	
	Map<TreeNode, Integer> map = new HashMap<>();

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) {
			return root;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if (left == right) {
			return root;
		} else if (left > right) {
			return subtreeWithAllDeepest(root.left);
		} else {
			return subtreeWithAllDeepest(root.right);
		}
	}

	public int depth(TreeNode root) {
		if (map.containsKey(root)) {
			return map.get(root);
		}
		if (root == null) {
			return 0;
		}
		int ld = depth(root.left);
		int rd = depth(root.right);
		int fd = Math.max(ld, rd) + 1;
		map.put(root, fd);
		return fd;
	}
}
