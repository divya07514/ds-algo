package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

	static TreeNode dummy;

	/**
	 * Not In-Place
	 * 
	 * @param root
	 */
	public static void flatten(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		preorder(list, root);
		root.left = null;
		TreeNode dummy = root;
		for (int i = 1; i < list.size(); i++) {
			TreeNode temp = list.get(i);
			temp.left = null;
			root.right = temp;
			root = root.right;
		}
		root = dummy;
	}

	public static void preorder(List<TreeNode> list, TreeNode root) {
		if (root != null) {
			list.add(root);
			preorder(list, root.left);
			preorder(list, root.right);
		}
	}

	/**
	 * In_place algo.
	 * 
	 * @param root
	 */
	public static void flatten_recursive(TreeNode root) {
        if(root==null){
            return;
        }
        if(root!=null && root.left==null && root.right==null){
            return;
        }
		dummy = root;
		TreeNode temp = dummy;
		dfs(root);
		temp  = root;
	}

	private static void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		dummy.right = root;
		dummy.left = null;
		dummy = dummy.right;
		dfs(left);
		dfs(right);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		root.right.right = new TreeNode(6);

		// flatten(root);
		flatten_recursive(root);
	}

}
