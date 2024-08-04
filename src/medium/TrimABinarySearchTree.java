package medium;

public class TrimABinarySearchTree {
	
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return root;
        }
        return trim(root,low,high);
    }

    private static TreeNode trim(TreeNode root, int low, int high){
            if(root==null){
                return null;
            }
            if(root.val>high){
                return trim(root.left,low,high);
            }else if(root.val<low){
                return trim(root.right,low,high);// 2
            }
            root.left = trim(root.left,low,high);
            root.right = trim(root.right,low,high);
            return root;
    }
        
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.left.right =  new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		root.right= new TreeNode(4);
		trim(root, 1, 3);

	}

}
