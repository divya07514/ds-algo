package ds_algo.divya.leetcode.practice;

public class DeepestLeavesSum {

	public static int deepestLeavesSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = maxDepth(root);
		int init = 1;
		if (depth == 1) {
			return root.val;
		}
		int sum = sum(root, depth, init);
		return sum;
	}

	private static int sum(TreeNode root, int maxDepth, int init) {
		if (root == null) {
			return 0;
		}
		if (init == maxDepth) {
			return root.val;
		}
		int left = sum(root.left, maxDepth, init + 1);
		int right=sum(root.right, maxDepth, init + 1);
		return left + right;
	}

	private static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.left.left = new TreeNode(7);

		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);

		System.out.println(deepestLeavesSum(root));
	}

}
