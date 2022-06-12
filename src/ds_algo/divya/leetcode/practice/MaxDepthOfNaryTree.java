package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;
import java.util.List;

public class MaxDepthOfNaryTree {

	public int maxDepth_levelOrderTraversal(Node root) {
		if (root == null) {
			return 0;
		}
		if (root != null && root.children.size() == 0) {
			return 1;
		}
		int depth = 0;
		LinkedList<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				Node temp = q.poll();
				if (temp.children != null && temp.children.size() > 0) {
					for (Node n : temp.children) {
						q.add(n);
					}
				}
				qs--;
			}
			depth++;
		}
		return depth;
	}

	public int maxDepth_recursive(Node root) {
		if (root == null) {
			return 0;
		}
		if (root != null && root.children.size() == 0) {
			return 1;
		}
		return depth(root);
	}

	private int depth(Node root) {
		if (root == null) {
			return 0;
		}
		int height = 0;
		if (root.children != null) {
			for (Node n : root.children) {
				int temp = depth(n);
				height = Math.max(temp, height);
			}
		}
		return 1 + height;
	}
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};
