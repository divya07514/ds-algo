package ds_algo.divya.leetcode.practice;

public class InorderSuccessorOfBST {
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		TreeNode result = null;
		TreeNode current = root;

		while (current != null) {
			if (current.val > p.val) {
				result = current;
				current = current.left;
			} else {
				current = current.right;
			}
		}

		return result;
	}
}
