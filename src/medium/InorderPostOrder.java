package medium;

import java.util.HashMap;
import java.util.Map;

public class InorderPostOrder {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		if (postorder.length != inorder.length) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		System.out.println(map);
		int n = inorder.length - 1;
		return build(inorder, 0, n, postorder, 0, n, map);
	}

	private static TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map) {
		if (ps > pe || is > ie) {
			return null;
		}
		int peNum = postorder[pe];
		TreeNode root = new TreeNode(peNum);
		int inRoot = map.get(peNum);
		System.out.println(inRoot);
		int numsLeft = inRoot - is;
		root.left = build(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, map);
		root.right = build(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, map);
		return root;
	}

	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		System.out.println(buildTree(inorder, postorder));

	}

}
