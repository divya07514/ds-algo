package medium;

/**
 * This deals with only Binary trees
 * 
 * @author divya.thakur
 *
 */
public class InorderSuccessorOfBinaryTree {

	TreeNode result;
	TreeNode previous;

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		// case 1: Where in the given p has right child and we need to find the leftmost
		// child sub rooted at p.right
		if (p.right != null) {
			TreeNode left = p.right;
			while (left.left != null) {
				left = left.left;
			}
			result = left;
		} else {
			// case 2: where p has no right child and we need to perform standard inorder
			// traversal and keep track of the previous node.
			inorderCase2(root, p);
		}
		return result;
	}

	private void inorderCase2(TreeNode root, TreeNode p) {
		if (root == null) {
			return;
		}
		inorderCase2(root.left, p);
		if (previous == p && result == null) {
			result = root;
			return;
		}
		previous = root;
		inorderCase2(root.right, p);
	}

}
