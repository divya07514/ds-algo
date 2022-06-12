package ds_algo.divya.leetcode.practice;

public class UnivaluedBinaryTree {
	public static boolean isUnivalTree(TreeNode root) {
		return populate(root, root.val);
	}

	public static boolean populate(TreeNode root, int val) {
		if (root != null) {
			if (root.val != val) {
				return false;
			}
			return populate(root.left, val) && populate(root.right, val);

		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		System.out.println(isUnivalTree(root));

	}
}
