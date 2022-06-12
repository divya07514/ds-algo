package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class CheckCompletenessOfABinaryTree {

	public boolean isCompleteTree(TreeNode root) {

		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean check = false;
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp == null) {
				check = true;
			} else {
				if (check) {
					return false;
				}
				q.add(temp.left);
				q.add(temp.right);
			}
		}
		return true;
	}

}
