package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKinBinaryTree {

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		setParents(parent, root);
		List<Integer> result = new ArrayList<Integer>();
		Set<TreeNode> set = new HashSet<>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(target);
		set.add(target);
		int level = 0;
		while (!q.isEmpty()) {
			if (level == k) {
				while (!q.isEmpty()) {
					result.add(q.poll().val);
				}
			}
			int qs = q.size();
			while (qs > 0) {
				TreeNode temp = q.poll();
				TreeNode p = parent.get(temp);
				if (!set.contains(p) && p != null) {
					q.add(p);
					set.add(p);
				}
				if (temp.left != null && !set.contains(temp.left)) {
					q.add(temp.left);
					set.add(temp.left);
				}
				if (temp.right != null && !set.contains(temp.right)) {
					q.add(temp.right);
					set.add(temp.right);
				}
				qs--;
			}
			level++;

		}

		return result;
	}

	private static void setParents(Map<TreeNode, TreeNode> parent, TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.left != null) {
				if (!parent.containsKey(temp.left)) {
					parent.put(temp.left, temp);
					q.add(temp.left);
				}
			}

			if (temp.right != null) {
				if (!parent.containsKey(temp.right)) {
					parent.put(temp.right, temp);
					q.add(temp.right);
				}
			}

		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		root.left = new TreeNode(5);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		/*
		 * TreeNode root = new TreeNode(0); root.left = new TreeNode(1); root.left.left
		 * = new TreeNode(3); root.left.right = new TreeNode(2);
		 */

		TreeNode target = root.left;

		int k = 2;

		System.out.println(distanceK(root, target, k));

	}

}
