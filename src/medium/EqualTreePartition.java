package medium;

/**
 * We have to look for a edge between root and a child where child cannot be original root.
 * edge case is [0,-1,1] tree.
 * @author divya.thakur
 *
 */
public class EqualTreePartition {

	boolean result;

	public boolean checkEqualTree(TreeNode root) {
		result = false;
		int total = sum(root);
		TreeNode original = root;
		System.out.println(total);
		check(root, original, total);
		return result;
	}

	private int check(TreeNode root, TreeNode original, int total) { 
		if (root == null) {
			return 0;
		}
		int left = check(root.left, original, total);
		int right = check(root.right, original, total);

		int sum = root.val + left + right;
		if (total % 2 == 0 && total / 2 == sum && root != original) { // current node and original root should be different
			result = true;
		}
		return sum;
	}

	private int sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = sum(root.left);
		int right = sum(root.right);
		return root.val + left + right;
	}

}
