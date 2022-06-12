package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
	
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		if (to_delete == null || to_delete.length == 0) {
			result.add(root);
			return result;
		}
		Set<Integer> set = new HashSet<>();
		for (int i : to_delete) {
			set.add(i);
		}
		delete(root, set, result);
		if (!set.contains(root.val)) {
			result.add(root);
		}
		return result;
	}

	public TreeNode delete(TreeNode root, Set<Integer> set, List<TreeNode> result) {
		if (root == null) {
			return null;
		}
		root.left = delete(root.left, set, result);
		root.right = delete(root.right, set, result);
		if (set.contains(root.val)) {
			if (root.left != null) {
				result.add(root.left);
			}
			if (root.right != null) {
				result.add(root.right);
			}
			return null;
		}
		return root;
	}
}
