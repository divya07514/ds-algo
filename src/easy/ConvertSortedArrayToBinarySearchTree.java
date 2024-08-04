package easy;

public class ConvertSortedArrayToBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right)/2;
		TreeNode root = new TreeNode(nums[mid]);
		search(left, right, nums, root);
		return root;
	}

	private static void search(int left, int right, int[] nums, TreeNode root) {
		int mid = (left + right) / 2;
		if (left > right) {
			return;
		}
		insert(nums[mid], root);
		search(left, mid - 1, nums, root);
		search(mid + 1, right, nums, root);
	}

	private static void insert(int val, TreeNode root) {
		if (val < root.val) {
			if (root.left == null) {
				root.left = new TreeNode(val);
				insert(val, root.left);
			}
		} else if(val > root.val) {
			if (root.right == null) {
				root.right = new TreeNode(val);
			} else {
				insert(val, root.right);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
			sortedArrayToBST(nums);
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

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
