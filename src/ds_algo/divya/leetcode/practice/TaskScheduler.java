package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	 public static int leastInterval(char[] tasks, int n) {
	        Map<Character, Integer> map = new HashMap<>();
	        for(char ch : tasks){
	            if(!map.containsKey(ch)){
	                map.put(ch,1);
	            }else{
	                map.put(ch,map.get(ch)+1);
	            }
	        }
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->  b-a);
	        pq.addAll(map.values());
	        int time = 0;
	        while(!pq.isEmpty()){
	            List<Integer> temp = new ArrayList<>();
	            for(int i=0;i<=n;i++){
	                if(!pq.isEmpty()){
	                    int item = pq.poll();
	                    temp.add(item);
	                }
	            }
	            for(int i : temp){
	                if(--i > 0){
	                    pq.add(i);
	                }
	            }
	            if(pq.isEmpty()) {
	            	time = time + temp.size();
	            }else {
	            	time =time +  n+1;
	            }
	        }
	        return time;
	    }

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 0;
		System.out.println(leastInterval(tasks, n));
	}

}
