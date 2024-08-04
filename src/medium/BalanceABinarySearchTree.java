package medium;

public class BalanceABinarySearchTree {

	static int i = 0;

	public static TreeNode balanceBST(TreeNode root) {

		if (root == null) {
			return null;
		}

		int count = countNodes(root);
		int[] array = new int[count];
		fillArray(root, array);
		i = 0;
		TreeNode node = new TreeNode(0);
		TreeNode result =buildTree(node, array, 0, array.length - 1);
		return result;
	}

	private  static TreeNode buildTree(TreeNode node, int[] array, int lo, int hi) {
		if (lo > hi) {
			return node;
		}
		int mid = lo + (hi - lo) / 2;
		if (node.val==0) {
			node = new TreeNode(array[mid]);
		} else {
			insert(node, array[mid]);
		}

		buildTree(node, array, lo, mid - 1);
		buildTree(node, array, mid + 1, hi);
		return node;
	}

	private  static void insert(TreeNode root, int i) {
		if (root.val > i) {
			if (root.left == null) {
				TreeNode node = new TreeNode(i);
				root.left = node;
				return;
			} else {
				insert(root.left, i);
			}
		} else if (root.val < i) {
			if (root.right == null) {
				TreeNode node = new TreeNode(i);
				root.right = node;
				return;
			} else {
				insert(root.right, i);
			}
		}

	}

	private  static void fillArray(TreeNode root, int[] array) {
		if (root == null) {
			return;
		}
		fillArray(root.left, array);
		array[i++] = root.val;
		fillArray(root.right, array);
	}

	private  static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	root.right = new TreeNode(2);
	root.right.right= new TreeNode(3);
	root.right.right.right= new TreeNode(4);
		System.out.println(balanceBST(root));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
}
