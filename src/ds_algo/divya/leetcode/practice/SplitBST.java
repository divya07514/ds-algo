package ds_algo.divya.leetcode.practice;

public class SplitBST {
	
	public TreeNode[] splitBST(TreeNode root, int V) {
		if (root == null) {
			return new TreeNode[] { null, null };
		}

		if (root.val <= V) {
			TreeNode[] array = splitBST(root.right, V);
			root.right = array[0];
			return new TreeNode[] { root, array[1] };
		} else {
			TreeNode[] array = splitBST(root.left, V);
			root.left = array[1];
			return new TreeNode[] { array[0], root };
		}

	}
}
