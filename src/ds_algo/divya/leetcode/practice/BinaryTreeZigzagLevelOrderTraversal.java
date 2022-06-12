package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<>();

		q.add(root);
		int level = 1;
		while (!q.isEmpty()) {
			int qs = q.size();
			List<Integer> temp = new ArrayList<>();
			while (qs > 0) {
				TreeNode node = q.poll();
				if (level % 2 == 1) {
					temp.add(node.val);
					if (node.left != null) {
						q.add(node.left);
					}
					if (node.right != null) {
						q.add(node.right);
					}
				} else {
					temp.add(0, node.val);
					if (node.left != null) {
						q.add(node.left);
					}
					if (node.right != null) {
						q.add(node.right);
					}
				}
				qs--;
			}
			result.add(temp);
			level++;
		}

		return result;
	}
}
