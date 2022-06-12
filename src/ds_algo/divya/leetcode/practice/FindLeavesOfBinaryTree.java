package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLeavesOfBinaryTree {

	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		findLeavesHelper(root, result);
		return result;
	}

	private static int findLeavesHelper(TreeNode root, List<List<Integer>> result) {
		if (root == null) {
			return -1;
		}
		int left = findLeavesHelper(root.left, result);
		int right = findLeavesHelper(root.right, result);
		int depth = Math.max(left, right) + 1;
		if (depth == result.size()) {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			result.add(list);
		} else {
			List<Integer> list = result.get(depth);
			list.add(root.val);
		}
		return depth;
	}

	public static List<List<Integer>> findLeaves_iterative(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<>();

		while (root != null) {
			q.add(root);
			List<Integer> list = new ArrayList<>();
			while (!q.isEmpty()) {
				int qs = q.size();
				while (qs > 0) {
					TreeNode temp = q.poll();
					if(root.left==null && root.right==null) {
						list.add(root.val);
						root=null;
					}
					if (temp.right != null) {
						if (temp.right.left != null || temp.right.right != null) {
							q.add(temp.right);
						}
						if (temp.right.left == null && temp.right.right == null) {
							list.add(temp.right.val);
							temp.right = null;
						}
					}
					if (temp.left != null) {
						if (temp.left.left != null || temp.left.right != null) {
							q.add(temp.left);
						}
						if (temp.left.left == null && temp.left.right == null) {
							list.add(temp.left.val);
							temp.left = null;
						}
					}
					qs--;
				}
			}
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(findLeaves(root));
		System.out.println(findLeaves_iterative(root));

	}

}
