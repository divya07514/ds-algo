package ds_algo.divya.leetcode.practice;

public class SumOfRootToLeafBinaryNumbers {

	static int result;

	public static int sumRootToLeaf(TreeNode root) {

		if (root == null) {
			return 0;
		}

		String s = "";
		result = 0;

		dfs(s, root);
		return result;
	}

	public static void dfs(String s, TreeNode root) {
		if (root == null) {
			return;
		}
		s = s + root.val;
		if (root.left == null && root.right == null) {
			result = result + Integer.parseInt(s, 2);
		}
		dfs(s, root.left);
		dfs(s, root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);

		System.out.println(sumRootToLeaf(root));

	}

}
