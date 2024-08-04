package medium;

public class ClosestBinarySearchTreeValue {

	public int closestValue(TreeNode root, double target) {
		int result = root.val;
		while (root != null) {
			int current = root.val;
			if (Math.abs(current - target) < Math.abs(result - target)) {
				result = current;
			} else if (Math.abs(current - target) == Math.abs(result - target)) {
				result = Math.min(current, result);
			}

			if (target < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return result;
	}

}
