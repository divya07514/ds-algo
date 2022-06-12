package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class FindDistanceInABinaryTree {
	TreeNode start;

	public int findDistance(TreeNode root, int p, int q) {

		if (root == null) {
			return 0;
		}

		if (p == q) {
			return 0;
		}
		Map<TreeNode, TreeNode> map = new HashMap<>();
		getParent(p, root, null, map);

		LinkedList<TreeNode> qq = new LinkedList<>();
		Set<TreeNode> set = new HashSet<>();
		int count = 0;
		qq.add(start);
		boolean found = false;
		while (!qq.isEmpty()) {
			int qs = qq.size();
			while (qs > 0) {
				TreeNode temp = qq.poll();
				TreeNode pa = map.get(temp);
				if (temp.val == q) {
					found = true;
					break;
				}
				if (!set.contains(pa) && pa != null) {
					qq.add(pa);
					set.add(pa);
				}

				if (temp.left != null && !set.contains(temp.left)) {
					qq.add(temp.left);
					set.add(temp.left);
				}
				if (temp.right != null && !set.contains(temp.right)) {
					qq.add(temp.right);
					set.add(temp.right);
				}

				qs--;
			}
			if (found) {
				break;
			}
			count++;
		}

		return count;
	}

	public void getParent(int p, TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
		if (root == null) {
			return;
		}
		if (p == root.val) {
			start = root;
		}
		if (!map.containsKey(root)) {
			map.put(root, parent);
		}

		getParent(p, root.left, root, map);
		getParent(p, root.right, root, map);
	}
}
