package medium;

public class CountNodesEqualToAverageOfSubtree {
	int count;

	public int averageOfSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		count = 0;
		average(root);
		return count;
	}

// int[0] == count and int[1] == sum
	private int[] average(TreeNode root) {
		if (root == null) {
			int[] temp = new int[2];
			temp[0] = 0;
			temp[1] = 0;
			return temp;
		}
		int[] left = average(root.left);
		int[] right = average(root.right);

		int sum = root.val + left[1] + right[1];
		int nodes = 1 + left[0] + right[0];
		int avg = sum / nodes;

		if (avg == root.val) {
			count++;
		}

		int[] array = new int[2];
		array[0] = nodes;
		array[1] = sum;
		return array;

	}
}
