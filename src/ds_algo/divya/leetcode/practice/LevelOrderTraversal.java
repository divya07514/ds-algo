package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Queue<TreeNode> q = new LinkedList();
		List<List<Integer>> list = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			int qs = q.size();
			List<Integer> res = new ArrayList();
			while (qs > 0) {
				TreeNode temp = q.poll();
				res.add(temp.val);
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				qs--;
			}
			list.add(res);
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(levelOrder(root));

	}

}
