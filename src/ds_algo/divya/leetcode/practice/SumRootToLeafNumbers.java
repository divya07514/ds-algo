package ds_algo.divya.leetcode.practice;

public class SumRootToLeafNumbers {

	static int sum;
	
	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		String temp = "";
		sum(root,temp);
		return sum;
	}

	private static void sum(TreeNode root,  String temp) {
		if (root == null) {
			return;
		}
		temp = temp + String.valueOf(root.val);
		if (root.left == null && root.right == null) {
			sum = sum + Integer.parseInt(temp);
		}
		sum(root.left,  temp);
		sum(root.right,temp);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		System.out.println(sumNumbers(root));

	}

}
