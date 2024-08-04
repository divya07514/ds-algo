package medium;

public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean check(TreeNode root, long left, long right) {
		if (root == null) {
			return true;
		}
		if (root.val <= left || root.val >= right) {
			return false;
		}
		return check(root.left, left, root.val) && check(root.right, root.val, right);
	}

}
