package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseOddLevelsOfBinaryTree {
	
	public TreeNode reverseOddLevels(TreeNode root) {
		if (root == null) {
			return root;
		}
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 1;
		while (!q.isEmpty()) {
			int qs = q.size();
			List<TreeNode> list = null;
			if (level % 2 != 0) {
				list = new ArrayList<>();
			}
			while (qs > 0) {
				TreeNode temp = q.poll();
				if (temp.left != null) {
					if (level % 2 != 0) {
						list.add(temp.left);
					}
					q.add(temp.left);
				}
				if (temp.right != null) {
					if (level % 2 != 0) {
						list.add(temp.right);
					}
					q.add(temp.right);
				}
				qs--;
			}
			if (level % 2 != 0) {
				int start = 0;
				int end = list.size() - 1;
				while (start <= end) {
					int temp = list.get(start).val;
					list.get(start).val = list.get(end).val;
					list.get(end).val = temp;
					start++;
					end--;
				}
			}
			level++;
		}
		return root;
	}
}
