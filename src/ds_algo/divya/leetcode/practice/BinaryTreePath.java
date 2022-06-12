package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

	public static List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return new ArrayList<String>();
		}
		List<String> list = new ArrayList<String>();
		String s = "";
		paths(root, list, s);
		return list;
	}

	private static void paths(TreeNode root, List<String> list, String s) {
		if (root.left == null && root.right == null) {
			s = s + root.val;
			list.add(s);
			return;
		}
		if (root.left != null) {
			paths(root.left, list, s + root.val + "->");
		}
		if (root.right != null) {
			paths(root.right, list, s + root.val + "->");
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if(root==null) {
			return true;
		}
		return balance(root);
	}

	private static boolean balance(TreeNode root) {
		if(root==null) {
			return true;
		}
		if(root!=null) {
			int leftH = check(root.left);
			int rightH = check(root.right);
			int heightDiff = Math.abs(rightH - leftH);
			if (heightDiff > 1) {
				return false;
			}
		}
		return balance(root.left) && balance(root.right);
	}

	private static int check(TreeNode root) {
		if (root==null) {
			return 0;
		}
		return 1 + Math.max(check(root.left), check(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(binaryTreePaths(root));
		System.out.println(isBalanced(root));
	}

}
