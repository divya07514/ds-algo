package ds_algo.divya.leetcode.practice;

public class BinaryTreeMaxPathSum {

	private static int result = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		sum(root);
		int answer = result;
		result = Integer.MIN_VALUE;
		return answer;
	}

	private static int sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = sum(root.left);
		int right = sum(root.right);
		int temp = 0;
		int answer = 0;
		if (Math.max(left, right) + root.val < root.val) {
			temp = root.val;
		} else {
			temp = Math.max(left, right) + root.val;
		}
		if (left + right + root.val < root.val) {
			answer = Math.max(temp, root.val);
		} else {
			answer = Math.max(temp, left + right + root.val);
		}

		result = Math.max(result, answer);
		return temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);

		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(maxPathSum(root));
	}

}
