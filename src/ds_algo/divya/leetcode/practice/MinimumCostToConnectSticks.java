package ds_algo.divya.leetcode.practice;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
	
	 public static int connectSticks(int[] nums) {
	        if(nums.length ==1){
	            return 0;
	        }
	        int cost = 0;
	        PriorityQueue<Integer> q = new PriorityQueue<>();
	        for(int i : nums){
	            q.add(i);
	        }
	        while(q.size()!=1){
	            int one = q.poll();
	            int two = q.poll();
	            cost = one + two + cost;
	            q.add(one + two);
	            
	        }
	        return cost;
	    }

	public static void main(String[] args) {
		int[] nums = {2,4,3};
		System.out.println(connectSticks(nums));
	}

}
