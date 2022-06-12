package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {

	/**
	 * Self implemented solution.
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>();
		if (root != null && root.left == null && root.right == null) {
			result.add(root.val);
			return result;
		}
		
		List<Integer> left = new ArrayList<>();
		if (root.left != null) {
			leftBoundary(root, left);
		} else {
			left.add(root.val);
		}

		List<Integer> leaf = new ArrayList<>();
		leaf(root, leaf);

		List<Integer> right = new ArrayList<>();
		if (root.right != null) {
			rightBoundary(root, right);
			Collections.reverse(right);
		}

		if (root.left != null && root.right != null) {
			leaf.remove(0);
			right.remove(0);
			right.remove(right.size() - 1);
		} else if (root.left == null) {
			right.remove(0);
			right.remove(right.size() - 1);
		} else if (root.right == null) {
			leaf.remove(0);
		}

		result(result, left);
		result(result, leaf);
		result(result, right);

		return result;

	}

	public void leftBoundary(TreeNode root, List<Integer> left) {
		if (root == null) {
			return;
		}
		left.add(root.val);
		if (root.left != null) {
			leftBoundary(root.left, left);
		} else {
			if (root.right != null) {
				leftBoundary(root.right, left);
			}
		}
	}

	public void result(List<Integer> result, List<Integer> temp) {
		for (int i : temp) {
			result.add(i);
		}
	}

	public void leaf(TreeNode root, List<Integer> leaf) {
		if (root == null) {
			return;
		}
		if (root != null && root.left == null && root.right == null) {
			leaf.add(root.val);
		}
		leaf(root.left, leaf);
		leaf(root.right, leaf);
	}

	public void rightBoundary(TreeNode root, List<Integer> right) {
		if (root == null) {
			return;
		}
		right.add(root.val);
		if (root.right != null) {
			rightBoundary(root.right, right);
		} else {
			if (root.left != null) {
				rightBoundary(root.left, right);
			}
		}
	}

	/**
	 * Leetcode solution
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> boundaryOfBinaryTree_leetcode(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (!isLeaf(root)) {
			res.add(root.val);
		}
		TreeNode t = root.left;
		// left boundary
		while (t != null) {
			if (!isLeaf(t)) {
				res.add(t.val);
			}
			if (t.left != null) {
				t = t.left;
			} else {
				t = t.right;
			}

		}
		// adding leaves
		addLeaves(res, root);
		Stack<Integer> s = new Stack<>();
		t = root.right;
		// right boundary.
		while (t != null) {
			if (!isLeaf(t)) {
				s.push(t.val);
			}
			if (t.right != null) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		while (!s.empty()) {
			res.add(s.pop());
		}
		return res;
	}

	public boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	public void addLeaves(List<Integer> res, TreeNode root) {
		if (isLeaf(root)) {
			res.add(root.val);
		} else {
			if (root.left != null) {
				addLeaves(res, root.left);
			}
			if (root.right != null) {
				addLeaves(res, root.right);
			}
		}
	}

}
