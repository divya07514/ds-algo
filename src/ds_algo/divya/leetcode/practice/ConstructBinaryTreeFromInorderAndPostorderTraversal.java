package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	private static int  pIndex;

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inorderIndices = new HashMap<Integer, Integer>();
		for(int i=0;i<inorder.length;i++) {
			inorderIndices.put(inorder[i], i);
		}
		pIndex = inorder.length-1;
		int inStart = 0;
		int inEnd = inorder.length -1;
		return build(inorder, postorder,inorderIndices,inStart,inEnd);
	}

	private static TreeNode build(int[] inorder, int[] postorder, Map<Integer, Integer> inorderIndices,int inStart, int inEnd) {
		if(inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[pIndex]);
		int rootIndex = inorderIndices.get(postorder[pIndex]);
		pIndex = pIndex -1;
		root.right = build(inorder, postorder, inorderIndices, rootIndex+1, inEnd);
		root.left = build(inorder, postorder, inorderIndices, inStart, rootIndex-1);
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
		int[] inorder = { 9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = buildTree(inorder, postorder);
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		preOrder(root);
		
		TreeNode temp = new TreeNode(1);
		temp.left  = new TreeNode(2);
		temp.right= new TreeNode(4);
		
		temp.left.left = new TreeNode(5);
		temp.left.right= new TreeNode(3);
		
		temp.right.left= new TreeNode(6);
		temp.right.right = new TreeNode(7);
		System.out.println();
		preOrder(temp);
	}

}













