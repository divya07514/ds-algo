package medium;

public class CountGoodNodesInBinaryTree {
	int count = 0;

	public int goodNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root != null && root.left == null && root.right == null) {
			return 1;
		}

		int max = root.val;
		good(root, max);

		int result = count;
		count = 0;
		return result;
	}

	private void good(TreeNode root, int max) {

		if (root == null) {
			return;
		}

		if (root.val >= max) {
			count++;
			max = root.val;
		}
		good(root.left, max);
		good(root.right, max);

	}
}
