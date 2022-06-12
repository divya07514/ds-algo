package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HouseRobber3 {

	public static int rob(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		return rob(root, map);
	}

	private static int rob(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}
		if (map.containsKey(root)) {
			return map.get(root);
		}
		int result = 0;
		if (root.left != null) {
			result = result + rob(root.left.left, map) + rob(root.left.right, map);
		}
		if (root.right != null) {
			result = result + rob(root.right.left, map) + rob(root.right.right, map);
		}
		int max = Math.max(root.val + result, rob(root.left, map) + rob(root.right, map));
		map.put(root, max);
		return max;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public int rob_leetcode(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] result = dfs(root);
        
        return Math.max(result[0],result[1]);
    }
    
	/**
	 * Store an array of two values, [rob,not_rob]
	 * @param root
	 * @return
	 */
    public int[] dfs(TreeNode root){
        
        if(root==null){
            return new int[2];
        }
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int rob = root.val + left[1] + right[1];
        int notrob = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        
        return new int[] {rob, notrob};
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		System.out.println(rob(root));
	}

}
