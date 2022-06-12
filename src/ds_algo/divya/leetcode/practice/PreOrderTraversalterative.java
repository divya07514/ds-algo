package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalterative {

	public static List<Integer> preorderTraversal(TreeNode root) {

		if(root==null) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> list = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			list.add(temp.val);

			if (temp.right != null) {
				stack.push(temp.right);
			}

			if (temp.left != null) {
				stack.push(temp.left);
			}
		}

		return list;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);

		root.right.left = new TreeNode(1);
		root.right.left.left = new TreeNode(5);
		root.right.left.right = new TreeNode(6);

		System.out.println(preorderTraversal(root));

	}

}
