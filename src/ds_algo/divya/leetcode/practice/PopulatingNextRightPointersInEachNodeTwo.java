package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeTwo {

	public NodeNextPointer connect_levelOrderTraversal(NodeNextPointer root) {
		if (root == null) {
			return null;
		}
		if (root != null && root.left == null && root.right == null) {
			return root;
		}
		LinkedList<NodeNextPointer> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				NodeNextPointer temp = q.poll();
				temp.next = q.peek();
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				qs--;
				if (qs == 0) {
					temp.next = null;
				}
			}
		}
		return root;
	}

	public NodeNextPointer connect_recursive(NodeNextPointer root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			} else {
				root.left.next = getNext(root.next);
			}
		}
		
		if(root.right!=null) {
			root.right.next = getNext(root.next);
		}
		connect_recursive(root.right);
		connect_recursive(root.left);
		return root;
	}

	private NodeNextPointer getNext(NodeNextPointer next) {
		if (next == null) {
			return null;
		}
		if (next.left != null) {
			return next.left;
		}
		if (next.right != null) {
			return next.right;
		}
		return getNext(next.next);
	}
}

class NodeNextPointer {
	public int val;
	public NodeNextPointer left;
	public NodeNextPointer right;
	public NodeNextPointer next;

	public NodeNextPointer() {
	}

	public NodeNextPointer(int _val) {
		val = _val;
	}

	public NodeNextPointer(int _val, NodeNextPointer _left, NodeNextPointer _right, NodeNextPointer _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
		
	}
};
