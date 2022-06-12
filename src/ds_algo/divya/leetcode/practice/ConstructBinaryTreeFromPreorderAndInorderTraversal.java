package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	static int pIndex = 0;

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		int start = 0;
		int end = inorder.length - 1;
		TreeNode root  =  build(preorder, inorder, start, end, map);
		pIndex = 0;
		return root;
	}

	private static TreeNode build(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map) {
		if (start > end) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pIndex]);
		int index = map.get(preorder[pIndex]);
		pIndex++;
		root.left = build(preorder, inorder, start, index - 1, map);
		root.right = build(preorder, inorder, index + 1, end, map);
		return root;
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
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		preOrder(buildTree(preorder, inorder));
		System.out.println();
		inOrder(buildTree(preorder, inorder));
		System.out.println();
		postOrder(buildTree(preorder, inorder));
	}

}
