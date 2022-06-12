package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static TreeNode bstFromPreorder(int[] preorder) {

		TreeNode root = new TreeNode();
		int rootValue = preorder[0];
		root.val = rootValue;
		for (int i = 1; i < preorder.length; i++) {
			int temp = preorder[i];
			insert(temp, root);
		}
		return root;
	}

	private static void insert(int item, TreeNode root) {
		if (item < root.val) {
			if (root.left != null) {
				insert(item, root.left);
			} else {
				TreeNode left = new TreeNode(item);
				root.left = left;
			}
		} else {
			if (root.right != null) {
				insert(item, root.right);
			} else {
				TreeNode right = new TreeNode(item);
				root.right = right;
			}
		}
	}

	private static void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val + " ");
		}
	}

	private static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		preOrder(bstFromPreorder(preorder));
		System.out.println();
		postOrder(bstFromPreorder(preorder));
		System.out.println();
		inOrder(bstFromPreorder(preorder));

	}

}
