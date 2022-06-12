package ds_algo.divya.leetcode.practice;

public class SmallestStringStartingFromLeaf {

	private static String min = "~";

	public static String smallestFromLeaf(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root != null && root.left == null && root.right == null) {
			int temp = root.val;
			char ch = (char) (temp + 97);
			return String.valueOf(ch);
		}
		strings("", root);
		String ans = min;
		min = "~";
		return ans;
	}

	private static void strings(String start, TreeNode root) {
		if (root == null) {
			return;
		}
		int temp = root.val;
		char ch = (char) (temp + 97);
		start = start + String.valueOf(ch);
		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder(start);
			sb.reverse();
			String res = sb.toString();
			if (res.compareTo(min) < 0) {
				min = res;
			}
			return;
		}
		strings(start, root.left);
		strings(start, root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(19);
		root.left = new TreeNode(10);
		System.out.println(smallestFromLeaf(root));

	}

}
