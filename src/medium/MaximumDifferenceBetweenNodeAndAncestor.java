package medium;

public class MaximumDifferenceBetweenNodeAndAncestor {

	public int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return max(root, root.val, root.val);
	}

	private int max(TreeNode root, int max, int min) {
		if (root == null) {
			return max - min;
		}
		max = Math.max(root.val, max);
		min = Math.min(root.val, min);
		int left = max(root.left, max, min);
		int right = max(root.right, max, min);
		return Math.max(left, right);
	}

}
