package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {

	/**
	 * Use extra space
	 * 
	 * @param root
	 * @return
	 */
	public NodeNextPointer connect_extra_space(NodeNextPointer root) {
		if (root == null) {
			return root;
		}
		LinkedList<NodeNextPointer> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				NodeNextPointer temp = q.poll();
				if (temp != null) {
					if (q.peek() != null && qs > 1) {
						temp.next = q.peek();
					}
					if (temp.left != null) {
						q.add(temp.left);
					}
					if (temp.right != null) {
						q.add(temp.right);
					}
				}
				qs--;
			}
		}
		return root;
	}

	/**
	 * No extra space
	 * @param root
	 * @return
	 */
	public NodeNextPointer connect(NodeNextPointer root) {
		if (root == null) {
			return root;
		}
		NodeNextPointer leftmost = root;
		while (leftmost.left != null) {
			NodeNextPointer head = leftmost;
			while (head != null) {
				head.left.next = head.right;
				if (head.next != null) {
					head.right.next = head.next.left;
				}
				head = head.next;
			}
			leftmost = leftmost.left;
		}
		return root;
	}
}
