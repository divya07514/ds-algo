package ds_algo.divya.leetcode.practice;

public class DeleteLeavesWithGivenValue {
	
	public TreeNode removeLeafNodes(TreeNode root, int target) {

		if (root == null) {
			return root;
		}
		if (root != null) {
			if (root.left == null && root.right == null) {
				if (root.val == target) {
					return null;
				} else {
					return root;
				}
			}
		}
		TreeNode result = delete(target, root);
		return result;
	}

	public TreeNode delete(int target, TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = delete(target, root.left);
		root.right = delete(target, root.right);
		if (root.left == null && root.right == null && root.val == target) {
			return null;
		}
		return root;
	}
}
