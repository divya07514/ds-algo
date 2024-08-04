package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Check conditions which are needed for validating a tree. Like only one root, no cycles, only one parent for each node except root.
 * Start by finding the root node and do A BFS. If you visit all nodes only once and there are no cycles , then it is a valid tree.
 * DO NOT use map to maintain parent child relationships. It does not work !!! spent an hour with this and could not make it work. :(
 * @author divya.thakur
 *
 */
public class ValidateBinaryTreeNodes {

	public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
		int root = findRoot(n, left, right);
		if (root == -1) {
			return false;
		}
		LinkedList<Integer> q = new LinkedList();
		Set<Integer> set = new HashSet();
		q.add(root);
		set.add(root);
		while (!q.isEmpty()) {
			int temp = q.poll();
			int lc = left[temp];
			int rc = right[temp];
			if (lc != -1) {
				if (set.contains(lc)) {
					return false;// child is already present. this means this child has more than 1 parent.
				} else {
					set.add(lc);
					q.add(lc);
				}
			}
			if (rc != -1) {
				if (set.contains(rc)) {
					return false;
				} else {
					set.add(rc);
					q.add(rc);
				}
			}
		}
		return set.size() == n;// is there are multiple roots then this will not return true.
	}

	private int findRoot(int n, int[] left, int[] right) {
		Set<Integer> set = new HashSet();
		for (int i : left) {
			set.add(i);
		}
		for (int i : right) {
			set.add(i);
		}
		for (int i = 0; i < n; i++) {
			if (!set.contains(i)) {
				return i; // return the first root that you encounter
			}
		}
		return -1;
	}

}
