package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		int currentSum = 0;
		sum(result, list, currentSum, sum, root);
		return result;
	}

	private static void sum(List<List<Integer>> result, List<Integer> list, int currentSum, int sum, TreeNode root) {
		if(root==null) {
			return;
		}
		currentSum = currentSum + root.val;
		list.add(root.val);
		if (currentSum == sum && root.left==null && root.right==null) {
			result.add(new ArrayList<Integer>(list));
		}
		sum(result, list, currentSum, sum, root.left);
		sum(result, list, currentSum, sum, root.right);
		int temp = list.remove(list.size() - 1);
		currentSum = currentSum - temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);

		root.right.right.right = new TreeNode(1);
		root.right.right.left = new TreeNode(5);
		System.out.println(pathSum(root, 22));
	}

}
