package ds_algo.divya.leetcode.practice;

public class SumOfLeftLeaves {

	private static int sum;

	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		sum(root);
		int result = sum;
		sum = 0;
		return result;
	}

	private static void sum(TreeNode root) {
		if(root==null) {
			return;
		}
		if (root.left != null && root.left.left == null && root.left.right == null) {
			sum = sum + root.left.val;
		}
		sum(root.left);
		sum(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		System.out.println(sumOfLeftLeaves(root));

	}

}
