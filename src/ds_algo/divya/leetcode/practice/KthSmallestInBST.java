package ds_algo.divya.leetcode.practice;

public class KthSmallestInBST {

	public static int kthSmallest(TreeNode root, int k) {
		if (root == null || k == 0) {
			return 0;
		}
		return smallest(root, k);
	}

	private static int smallest(TreeNode root, int k) {
		int count = getNodeCount(root.left) + 1;
		if (count == k) {
			return root.val;
		}
		if (k - count < 0) {
			return kthSmallest(root.left, k);
		} else {
			return kthSmallest(root.right, k - count);
		}
	}

	private static int getNodeCount(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + getNodeCount(root.left) + getNodeCount(root.right);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);

		System.out.println(kthSmallest(root, 6));
	}

}
