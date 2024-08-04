package medium;

public class LCAofDeepestNodes {

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) {
			return root;
		}
		return find(root).node;
	}

	private Pair find(TreeNode root) {
		if (root == null) {
			return new Pair(root, 0);
		}

		Pair left = find(root.left);
		Pair right = find(root.right);

		if (left.depth > right.depth) {
			return new Pair(left.node, left.depth + 1);
		} else if (right.depth > left.depth) {
			return new Pair(right.node, right.depth + 1);
		} else {
			return new Pair(root, left.depth + 1);
		}
	}

}

class Pair {
	TreeNode node;
	int depth;

	Pair(TreeNode node, int depth) {
		this.node = node;
		this.depth = depth;
	}
}