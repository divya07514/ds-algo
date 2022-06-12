package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;
import java.util.Queue;


public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp == null) {
				sb.append("n");
				sb.append(",");
			} else {
				sb.append(temp.val);
				sb.append(",");
				q.add(temp.left);
				q.add(temp.right);
			}
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data == null) {
			return null;
		}
		if (data.isEmpty()) {
			return null;
		}
		String[] array = data.split(",");
		int index = 0;
		TreeNode root = getNode(array[index++]);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			if(temp!=null) {
				temp.left=getNode(array[index++]);
				temp.right=getNode(array[index++]);
				q.add(temp.left);
				q.add(temp.right);
			}
		}
		return root;
	}

	private static TreeNode getNode(String p) {
		if (p.equals("n"))
			return null;
		return new TreeNode(Integer.parseInt(p));
	}

	private static void traverse(TreeNode root) {
		if (root != null) {
			traverse(root.left);
			System.out.print(root.val + " ");
			traverse(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		
		String input = serialize(root);
		System.out.println(input);
		TreeNode result = deserialize(input);
		traverse(result);

	}
}
