package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumDifferenceBetweenNodeAndAncestor {

	static int max;
	/**
	 * Self implemented solution
	 * @param root
	 * @return
	 */
	static public int maxAncestorDiff(TreeNode root) {
		max = Integer.MIN_VALUE;
		if (root == null) {
			return 0;
		}
		List<List<Integer>> paths = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		getAllPaths(root, paths, temp);
		for(List<Integer>list : paths) {
			Collections.sort(list);
			max = Math.max(max, list.get(list.size()-1)-list.get(0));
		}
		return max;
	}

	static public void getAllPaths(TreeNode root, List<List<Integer>> paths, List<Integer> temp) {
		if(root==null) {
			return;
		}
		temp.add(root.val);
		if (root != null && root.left == null && root.right == null) {
			List<Integer> list = new ArrayList<>(temp);
			paths.add(list);
			return;
		}
		getAllPaths(root.left, paths, new ArrayList<Integer>(temp));
		getAllPaths(root.right, paths, new ArrayList<Integer>(temp));

	}
	
	/**
	 * Leetcode solution
	 * @param root
	 * @return
	 */
    public static  int maxAncestorDiff_another(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max = root.val;
        int min = root.val;
        return getResult(root,max,min);
    }
    
    public static int getResult(TreeNode root, int max, int min){
        if(root==null){
            return max - min;
        }
        max = Math.max(max,root.val);
        min = Math.min(min, root.val);
        int left = getResult(root.left,max,min);
        int right = getResult(root.right,max,min);
        return Math.max(left,right);
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.left= new TreeNode(1);
		root.left.right= new TreeNode(6);
		root.left.right.left= new TreeNode(4);
		root.left.right.right= new TreeNode(7);
		
		root.right= new TreeNode(10);
		root.right.right= new TreeNode(14);
		root.right.right.left= new TreeNode(13);
		System.out.println(maxAncestorDiff_another(root));

	}

}
