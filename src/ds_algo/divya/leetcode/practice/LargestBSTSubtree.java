package ds_algo.divya.leetcode.practice;

public class LargestBSTSubtree {
	
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Bst result = traverse(root);
		return result.size;
	}

	public Bst traverse(TreeNode root) {
		Bst temp = new Bst();
		if (root != null) {
			Bst left = traverse(root.left);
			Bst right = traverse(root.right);
			if (left.isBst && right.isBst && left.max < root.val && right.min > root.val) {
				temp.min = (left.min == Integer.MAX_VALUE) ? root.val : left.min;
				temp.max = (right.max == Integer.MIN_VALUE) ? root.val : right.max;
				temp.isBst = true;
				temp.size = 1 + left.size + right.size;
			} else {
				temp.size = Math.max(left.size, right.size);
				temp.isBst = false;
			}
		}
		return temp;
	}

}

class Bst {

	int size;
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	boolean isBst;

	public Bst() {
		this.size = 0;
		this.min = Integer.MAX_VALUE;
		this.max = Integer.MIN_VALUE;
		this.isBst = true;
	}

	public String toString() {
		return size + "," + min + "," + max + "," + isBst;
	}

}