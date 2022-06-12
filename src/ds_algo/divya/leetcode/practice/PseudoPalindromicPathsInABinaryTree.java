package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsInABinaryTree {
	int count;

	public int pseudoPalindromicPaths(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root != null && root.left == null && root.right == null) {
			return 1;
		}
		count = 0;
		dfs(root, "");
		return count;
	}

	public void dfs(TreeNode root, String temp) {
		if (root == null) {
			return;
		}
		temp = temp + root.val;
		if (root.left == null && root.right == null) {
			if (checkPalindrome(temp)) {
				count++;
			}
		}
		dfs(root.left, temp);
		dfs(root.right, temp);
	}

	public boolean checkPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		boolean onlyOne = true;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
				onlyOne = false;
			}
		}
		if (onlyOne) {
			return false;
		}
		int countOdd = 0;
		for (char ch : map.keySet()) {
			if (map.get(ch) % 2 == 1) {
				countOdd++;
			}
		}
		if (countOdd > 1) {
			return false;
		}

		return true;
	}
}
