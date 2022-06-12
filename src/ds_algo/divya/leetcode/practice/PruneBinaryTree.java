package ds_algo.divya.leetcode.practice;

public class PruneBinaryTree {

	public TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		if (root != null) {
			if (root.left == null && root.right == null) {
				if (root.val != 0) {
					return root;
				} else {
					return null;
				}
			}
		}
		TreeNode result = prune(root);
		return result;
	}

	public TreeNode prune(TreeNode root) {
		if (root == null) {
			return root;
		}
		root.left = prune(root.left);
		root.right = prune(root.right);

		if (root.left == null && root.right == null && root.val == 0) {
			return null;
		}
		return root;
	}

}
