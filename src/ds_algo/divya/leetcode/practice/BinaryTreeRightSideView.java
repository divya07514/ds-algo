package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BinaryTreeRightSideView {

	public static List<Integer> rightSideView_iterative(TreeNode root) {
		List<Integer> result = new ArrayList();
		if (root == null) {
			return result;
		}
		if (root != null && root.left == null && root.right == null) {
			result.add(root.val);
			return result;
		}
		LinkedList<TreeNode> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			int qs = q.size();
			int last = -1;
			while (qs > 0) {
				TreeNode temp = q.poll();
				last = temp.val;
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				qs--;
			}
			result.add(last);
		}
		return result;
	}
	
    public static List<Integer> rightSideView_recursive(TreeNode root) {
		List<Integer> result = new ArrayList();
		if (root == null) {
			return result;
		}
		if (root != null && root.left == null && root.right == null) {
			result.add(root.val);
			return result;
		}
		Set<Integer> seen = new HashSet<Integer>();
		result.add(root.val);
        view(result,root,0,seen);
        return result;
    }

	private static void view(List<Integer> result, TreeNode root, int level, Set<Integer> seen) {
		if(root==null) {
			return;
		}
		if(root.right!=null && !seen.contains(level)) {
			seen.add(level);
			result.add(root.right.val);
		}
		view(result, root.right, level+1, seen);
		view(result, root.left, level+1, seen);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode(3);
		root.left.right= new TreeNode(5);
		root.right.right= new TreeNode(4);
		System.out.println(rightSideView_iterative(root));
		System.out.println(rightSideView_recursive(root));
	}

}
