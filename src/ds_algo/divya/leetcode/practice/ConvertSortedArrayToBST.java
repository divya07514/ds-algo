package ds_algo.divya.leetcode.practice;

public class ConvertSortedArrayToBST {

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int i = 0;
		int j = nums.length - 1;
		int mid = (i + j) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		binarySearchRecursive(root, i, j, nums);
		return root;
	}
	
	public static TreeNode sortedArrayToBST_another(int[] nums) {
        if(nums==null){
            return null;
        }
        if(nums.length==0){
            return new TreeNode();
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        int left = 0;
        int right = nums.length - 1;
        return build(nums,left,right);
    }
    
    public static TreeNode build(int[] nums, int left, int right){
        if(left>right){
            return null;
        }
        int mid  = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,left,mid-1);
        root.right = build(nums,mid+1,right);
        return root;
    }

	private static void binarySearchRecursive(TreeNode root, int i, int j, int[] nums) {
		int mid = (i + j) / 2;
		if (i > j) {
			return;
		}
		if (root == null) {
			root = new TreeNode(nums[mid]);
		} else {
			insert(nums[mid], root);
		}

		binarySearchRecursive(root, i, mid - 1, nums);
		binarySearchRecursive(root, mid + 1, j, nums);

	}

	private static void insert(int item, TreeNode root) {
		if (item < root.val) {
			if (root.left != null) {
				insert(item, root.left);
			} else {
				TreeNode newNode = new TreeNode(item);
				root.left = newNode;
			}
		} else {
			if (item > root.val) {
				if (root.right != null) {
					insert(item, root.right);
				} else {
					TreeNode newNode = new TreeNode(item);
					root.right = newNode;
				}
			}
		}
	}

	private static void traversal(TreeNode root) {
		if (root != null) {
			traversal(root.left);
			System.out.print(root.val + " ");
			traversal(root.right);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3, 4, 5 };
		traversal(sortedArrayToBST(nums));
		System.out.println();
		traversal(sortedArrayToBST_another(nums));
	}

}
