package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

	public static List<Integer> getAllElements(TreeNode r1, TreeNode r2) {
		List<Integer> l1 = new ArrayList<>();
		if (r1 != null) {
			inorder(r1, l1);
		}
		List<Integer> l2 = new ArrayList<>();
		if (r2 != null) {
			inorder(r2, l2);
		}

		int i = 0;
		int j = 0;
		List<Integer> result = new ArrayList<>();
		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i) < l2.get(j)) {
				result.add(l1.get(i));
				i++;
			} else {
				result.add(l2.get(j));
				j++;
			}
		}

		if (i < l1.size()) {
			addLeft(i, l1, result);
		}

		if (j < l2.size()) {
			addLeft(j, l2, result);
		}

		return result;
	}

	public static void addLeft(int i, List<Integer> list, List<Integer> result) {
		while (i < list.size()) {
			result.add(list.get(i++));
		}
	}

	public static void inorder(TreeNode root, List<Integer> result) {
		if (root != null) {
			inorder(root.left, result);
			result.add(root.val);
			inorder(root.right, result);
		}
	}

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(2);
		r1.left = new TreeNode(1);
		r1.right = new TreeNode(4);

		TreeNode r2 = new TreeNode(1);
		r2.left = new TreeNode(0);
		r2.right = new TreeNode(3);

		System.out.println(getAllElements(r1, r2));

	}

}
