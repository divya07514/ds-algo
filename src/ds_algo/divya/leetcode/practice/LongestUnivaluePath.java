package ds_algo.divya.leetcode.practice;

public class LongestUnivaluePath {
	int result;

	public int longestUnivaluePath(TreeNode root) {
		result = 0;

		dfs(root);

		return result;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);

		if (root != null && root.left != null && root.val == root.left.val) {
			left = left + 1;
		} else {
			left = 0;
		}

		if (root != null && root.right != null && root.val == root.right.val) {
			right = right + 1;
		} else {
			right = 0;
		}

		result = Math.max(result, left + right);
		return Math.max(left, right);
	}
}
