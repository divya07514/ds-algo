package ds_algo.divya.leetcode.practice;

public class CountGoodNodesInBinaryTree {
	
	int result;

	public int goodNodes(TreeNode root) {
		result = 0;
		int max = root.val;
		dfs(root, max);
		return result;
	}

	public void dfs(TreeNode root, int max) {
		if (root == null) {
			return;
		}
		if (root.val >= max) {
			result++;
			max = root.val;
		}
		dfs(root.left, max);
		dfs(root.right, max);
	}
}
