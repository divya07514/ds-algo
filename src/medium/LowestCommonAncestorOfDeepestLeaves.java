package medium;

public class LowestCommonAncestorOfDeepestLeaves {
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) {
			return root;
		}
		if (root != null && root.left == null && root.right == null) {
			return root;
		}
		return lca(root);
	}

	private TreeNode lca(TreeNode root) {
		if (root == null) {
			return root;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if (left == right) {
			return root;
		} else if (left < right) {
			return lca(root.right);
		} else {
			return lca(root.left);
		}
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
}
