package ds_algo.divya.leetcode.practice;

public class BinaryTreeLongestConsecutiveSequence {

	static int result;

	public static int longestConsecutive(TreeNode root) {
		result = 0;

		dfs(root);

		return result;
	}

	public static int dfs(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = dfs(root.left) + 1;
		int right = dfs(root.right) + 1;

		if (root != null && root.left != null && root.val - root.left.val != -1) {
			left = 1;
		}

		if (root != null && root.right != null && root.val - root.right.val != -1) {
			right = 1;
		}

		result = Math.max(result, Math.max(left, right));
		return Math.max(right, left);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(3);

		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(1);
		System.out.println(longestConsecutive(root));
	}

}
