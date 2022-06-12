package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestCommonAncestor {

	/**
	 * Works for both BST and Binary Tree.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
		populateParents(root, map, null);
		if (map.get(p) == map.get(q)) {
			return map.get(p);
		}
		if (map.get(p) == q) {
			return q;
		}
		if (map.get(q) == p) {
			return p;
		}
		if (map.get(q) == null || map.get(p) == null) {
			return root;
		}
		TreeNode parentP = map.get(p);
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(p);
		while (parentP != null) {
			list.add(parentP);
			parentP = map.get(parentP);
		}
		while (!list.contains(q)) {
			q = map.get(q);
		}
		return q;
	}

	private static void populateParents(TreeNode root, Map<TreeNode, TreeNode> map, TreeNode parent) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(root)) {
			map.put(root, parent);
		}
		populateParents(root.left, map, root);
		populateParents(root.right, map, root);
	}

	/**
	 * This will work only in case of a BST;
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor_recursive(root.right, p, q);
		} else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor_recursive(root.left, p, q);
		} else {
			return root;
		}
	}

	/**
	 * LCA without extra space.
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor_constantSpace(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		return lca(root, p, q);
	}

	public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		if (left == null && right == null) {
			return null;
		}
		if (left != null && right == null) {
			return left;
		}
		if (left == null && right != null) {
			return right;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		System.out.println(lowestCommonAncestor(root, root.left.left, root.left));
		System.out.println(lowestCommonAncestor_constantSpace(root, root.left.left, root.right.right));
		System.out.println(lowestCommonAncestor_recursive(root, root.left.left, root.right.right));
	}

}
