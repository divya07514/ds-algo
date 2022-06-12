package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
	
	   public static List<Integer> largestValues(TreeNode root) {
	        List<Integer> result = new ArrayList();
	        if(root==null){
	            return result;
	        }
	        if(root!=null && root.left==null && root.right==null){
	            result.add(root.val);
	            return result;
	        }
	        LinkedList<TreeNode> q = new LinkedList();
	        q.add(root);
	        while(!q.isEmpty()){
	            int qs = q.size();
	            int max = Integer.MIN_VALUE;
	            while(qs > 0){
	                TreeNode temp = q.poll();
	                max = Math.max(max,temp.val);
	                if(temp.left!=null){
	                    q.add(temp.left);
	                }
	                if(temp.right!=null){
	                    q.add(temp.right);
	                }
	                qs--;
	            }
	            result.add(max);
	        }
	        return result;
	    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left= new TreeNode(3);
		root.right= new TreeNode(2);
		
		root.left.left= new TreeNode(5);
		root.left.right= new TreeNode(3);
		
		root.right.right= new TreeNode(9);
		
		System.out.println(largestValues(root));

	}

}
