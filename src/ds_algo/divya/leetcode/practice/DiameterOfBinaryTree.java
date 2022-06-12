package ds_algo.divya.leetcode.practice;

public class DiameterOfBinaryTree {

	private static int ans;

	public static int diameterOfBinaryTree(TreeNode root) {
		ans = 0;
		if (root == null) {
			return 0;
		}
		diameter(root);
		return ans -1 ;
	}

	private static int diameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = diameter(root.left);
		int right = diameter(root.right);
		ans = Math.max(ans, left + right + 1);
		return Math.max(left,right) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(diameterOfBinaryTree(root));
	}
}
