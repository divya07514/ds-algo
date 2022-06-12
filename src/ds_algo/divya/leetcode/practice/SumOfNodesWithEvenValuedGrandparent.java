package ds_algo.divya.leetcode.practice;

public class SumOfNodesWithEvenValuedGrandparent {

	static int sum;

	public static int sumEvenGrandparent(TreeNode root) {
		if (root == null) {
			return 0;
		}
		sum = 0;
		sum(root, null, null);
		int result = sum;
		return result;
	}

	private static void sum(TreeNode root, TreeNode parent, TreeNode grandParent) {
		if (root == null) {
			return;
		}
		if (grandParent != null && grandParent.val % 2 == 0) {
			sum = sum + root.val;
		}
		sum(root.left, root, parent);
		sum(root.right, root, parent);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(7);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);

		root.left.left.left = new TreeNode(9);

		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(4);

		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);

		root.right.right.right = new TreeNode(5);

		System.out.println(sumEvenGrandparent(root));

	}

}
