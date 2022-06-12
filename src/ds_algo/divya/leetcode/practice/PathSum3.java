package ds_algo.divya.leetcode.practice;

public class PathSum3 {

	static int count = 0;

	public static int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		sum(root, sum);
		int res = count;
		count = 0;
		return res;
	}

	private static void sum(TreeNode root, int sum) {
		int currentSum = 0;
		helper(root, sum, currentSum);
		if (root != null && root.left != null) {
			sum(root.left, sum);
		}
		if (root != null && root.right != null) {
			sum(root.right, sum);
		}
	}

	private static void helper(TreeNode root, int sum, int currentSum) {
		if (root == null) {
			return;
		}
		currentSum = currentSum + root.val;
		if (currentSum == sum) {
			count = count + 1;
		}
		helper(root.left, sum, currentSum);
		helper(root.right, sum, currentSum);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);

		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);

		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);

		System.out.println(pathSum(root, 8));

	}

}
