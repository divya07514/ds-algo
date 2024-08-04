package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class AmountofTimeforBinaryTreetoBeInfected {

	TreeNode start;

	public int amountOfTime(TreeNode root, int i) {
		if (root == null) {
			return 0;
		}
		start = null;
		findNode(root, i);
		Map<TreeNode, TreeNode> map = new HashMap();
		getParents(root, null, map);
		LinkedList<TreeNode> q = new LinkedList();
		Set<TreeNode> set = new HashSet();
		q.add(start);
		int count = 0;

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				TreeNode temp = q.poll();
				if (temp.left != null && !set.contains(temp.left)) {
					q.add(temp.left);
				}
				if (temp.right != null && !set.contains(temp.right)) {
					q.add(temp.right);
				}
				if (!set.contains(map.get(temp)) && map.get(temp) != null) {
					q.add(map.get(temp));
				}
				set.add(temp);
				qs--;
			}
			count++;
		}

		return count - 1;
	}

	private void getParents(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
		if (root == null) {
			return;
		}
		map.put(root, parent);
		getParents(root.left, root, map);
		getParents(root.right, root, map);
	}

	private void findNode(TreeNode root, int i) {
		if (root == null) {
			return;
		}
		if (root.val == i) {
			start = root;
			return;
		}
		findNode(root.left, i);
		findNode(root.right, i);
	}

}
