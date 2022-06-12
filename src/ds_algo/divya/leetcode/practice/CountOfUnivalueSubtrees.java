package ds_algo.divya.leetcode.practice;

public class CountOfUnivalueSubtrees {

	static int count;

	public static int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		count = 0;
		count(root);
		return count;
	}

	public static boolean count(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean left = count(root.left);
		boolean right = count(root.right);
		if (!left || !right) {
			return false;
		}
		if (root.left != null && root.left.val != root.val) {
			return false;
		}
		if (root.right != null && root.right.val != root.val) {
			return false;
		}
		count++;
		return true;
	}

}
