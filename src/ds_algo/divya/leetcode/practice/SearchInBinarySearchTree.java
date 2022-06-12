package ds_algo.divya.leetcode.practice;

public class SearchInBinarySearchTree {

	static public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		return search(root, val);
	}

	private static TreeNode search(TreeNode root, int val) {
		if (root != null) {
			if (root.val == val) {
				return root;
			} else if (val < root.val) {
				return search(root.left, val);
			} else {
				return search(root.right, val);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		TreeNode node = searchBST(root, 6);
		traversal(node);
	}

	private static void traversal(TreeNode root) {
		if (root != null) {
			traversal(root.left);
			System.out.print(root.val + " ");
			traversal(root.right);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
	
	
}
