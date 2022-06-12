package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PostTraversalIterative {

	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		Set<TreeNode> set = new HashSet<TreeNode>();
		Set<TreeNode> seen = new HashSet<TreeNode>();
		while(!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if(!seen.contains(temp)) {
				seen.add(temp);
			}else {
				TreeNode tn = stack.pop();
				result.add(tn.val);
			}
			if(temp.right!=null && !set.contains(temp.right)) {
				stack.push(temp.right);
				set.add(temp.right);
			}
			if(temp.left!=null && !set.contains(temp.left)) {
				stack.push(temp.left);
				set.add(temp.left);
			}
		}
		return result;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);

		root.right.left = new TreeNode(1);
		root.right.left.left = new TreeNode(5);
		root.right.left.right=new TreeNode(6);

		System.out.println(postorderTraversal(root));

	}

}
