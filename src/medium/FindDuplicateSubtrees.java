package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Idea is to serialise a tree and generate string representation of it. Take
 * special care when you encounter null nodes. You still need to add a value for
 * it in the final string otherwise different trees may give you same
 * serialised string.
 * 
 * @author divya.thakur
 *
 */
public class FindDuplicateSubtrees {

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if (root == null) {
			return new ArrayList();
		}

		Set<String> set = new HashSet();
		Map<String, TreeNode> map = new HashMap();
		dfs(root, set, map);
		List<TreeNode> result = new ArrayList<>(map.values());

		return result;
	}

	private void dfs(TreeNode root, Set<String> set, Map<String, TreeNode> map) {
		if (root == null) {
			return;
		}
		String str = postorder(root);
		if (!set.contains(str)) {
			set.add(str);
		} else {
			map.put(str, root);
		}
		dfs(root.left, set, map);
		dfs(root.right, set, map);
	}

	private String postorder(TreeNode root) {
		if (root == null) {
			return "";
		}
		String left = postorder(root.left);
		String right = postorder(root.right);
		return root.val + "#" + left + "#" + right;
	}

}
