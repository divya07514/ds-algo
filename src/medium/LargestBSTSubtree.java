package medium;

public class LargestBSTSubtree {

	int result;

	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		result = Integer.MIN_VALUE;
		check(root);
		return result;
	}

	private void check(TreeNode root) {
		if (root == null) {
			return;
		}
		boolean isBST = bst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		if (isBST) {
			int count = count(root);
			result = Math.max(result, count);
		}
		check(root.left);
		check(root.right);
	}

	private int count(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + count(root.left) + count(root.right);
	}

	private boolean bst(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return bst(root.left, min, root.val) && bst(root.right, root.val, max);
	}

}
