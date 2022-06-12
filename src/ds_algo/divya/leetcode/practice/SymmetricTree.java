package ds_algo.divya.leetcode.practice;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}
		if (root != null && root.left == null && root.right == null) {
			return true;
		}
		return check(root, root);
	}

	private boolean check(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		}
		if (one == null || two == null) {
			return false;
		}
		return (one.val == two.val) && check(one.left, two.right) && check(one.right, two.left);
	}
}
