package ds_algo.divya.leetcode.practice;

public class SameTree {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		return check(p, q);
	}

	private static boolean check(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if(p==null || q==null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return check(p.left, q.left) && check(p.right, q.right);
	}

	public static void main(String[] args) {

		TreeNode r1 = new TreeNode(1);
		r1.left = new TreeNode(2);
		//r1.right = new TreeNode(2);

		TreeNode r2 = new TreeNode(1);
		//r2.left = new TreeNode(2);
		r2.right = new TreeNode(2);
		System.out.println(isSameTree(r1, r2));
	}

}
