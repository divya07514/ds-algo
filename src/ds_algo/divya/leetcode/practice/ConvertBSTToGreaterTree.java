package ds_algo.divya.leetcode.practice;

public class ConvertBSTToGreaterTree {

	private static int sum = 0;
	public static TreeNode convertBST(TreeNode root) {
		if(root==null) {
			return null;
		}
		if(root!=null && root.left==null && root.right==null) {
			return root;
		}
		inorder(root);
		sum =0;
		return root;
	}
	

	public static void inorder(TreeNode root) {
		if(root!=null) {
			inorder(root.right);
			sum = root.val + sum;
			root.val=sum;
			inorder(root.left);
		}
	}
	
	public static void print(TreeNode root) {
		if(root!=null) {
			print(root.left);
			System.out.print(root.val+" ");
			print(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		
		root.left.left= new TreeNode(0);
		root.left.right= new TreeNode(2);
		root.left.right.right= new TreeNode(3);
		
		root.right.left= new TreeNode(5);
		root.right.right= new TreeNode(7);
		root.right.right.right= new TreeNode(8);
		convertBST(root);
		print(root);
	}

}
