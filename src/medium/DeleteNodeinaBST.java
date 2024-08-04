package medium;

public class DeleteNodeinaBST {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		if (root != null && root.left == null && root.right == null && root.val == key) {
			return null;
		}
		TreeNode result = delete(root, key);
		return result;
	}

	private TreeNode delete(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		if (key < root.val) {
			root.left = delete(root.left, key);
			return root;
		} else if (key > root.val) {
			root.right = delete(root.right, key);
			return root;
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				TreeNode next = root.right;
				while (next.left != null) {
					next = next.left;
				}
				root.val = next.val;
				root.right = delete(root.right, next.val);
				return root;
			}
		}

	}

}
