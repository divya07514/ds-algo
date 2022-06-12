package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class MaximumBinaryTree {

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		TreeNode root = null;
		int left = 0;
		int right = nums.length;
		TreeNode result = construct(root, nums, left, right);
		return result;
	}

	private static TreeNode construct(TreeNode root, int[] nums, int left, int right) {
		if (nums.length == 0) {
			return root;
		}
		int index = getMaxIndex(nums);
		if (root == null) {
			root = new TreeNode(nums[index]);
		}

		int[] leftArray = Arrays.copyOfRange(nums, left, index);
		root.left = construct(root.left, leftArray, 0, leftArray.length);

		int[] rightArray = Arrays.copyOfRange(nums, index + 1, right);
		root.right = construct(root.right, rightArray, 0, rightArray.length);

		return root;
	}

	private static int getMaxIndex(int[] nums) {
		int max = nums[0];
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		constructMaximumBinaryTree(nums);
	}

}
