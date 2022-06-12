package ds_algo.divya.leetcode.practice;

public class MaximumAverageTree {

	double average;

	/**
	 * Self implemented solution
	 * 
	 * @param root
	 * @return
	 */
	public double maximumAverageSubtree(TreeNode root) {
		if (root == null) {
			return 0.0;
		}
		average = Double.NEGATIVE_INFINITY;
		findAverage(root);
		return average;
	}

	public void findAverage(TreeNode root) {
		int totalNodes = countNodes(root);
		double sum = sum(root);
		average = Math.max(average, sum / totalNodes);
		if (root.left != null) {
			findAverage(root.left);
		}
		if (root.right != null) {
			findAverage(root.right);
		}
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public double sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.val + sum(root.left) + sum(root.right);
	}

	/**
	 * Leet code solution. Better approach then above as it stores the results for
	 * children nodes and then uses it to calculate values for the parent.
	 * 
	 * @param root
	 * @return
	 */
	public double maximumAverageSubtree_leetcode(TreeNode root) {
		dfs(root);
		return average;
	}

	public double[] dfs(TreeNode root) {
		if (root == null) {
			return new double[] { 0.0, 0.0 };
		}
		double[] left = dfs(root.left);
		double[] right = dfs(root.right);
		double sum = left[0] + right[0] + root.val;
		double numElements = left[1] + right[1] + 1;
		average = Math.max(sum / numElements, average);
		return new double[] { sum, numElements };
	}

}
