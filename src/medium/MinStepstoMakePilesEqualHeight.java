package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinStepstoMakePilesEqualHeight {

	private static int min(int[] input) {
		if(input==null || input.length==0) {
			return 0;
		}
		
		Map<Integer, Integer> map = new HashMap();
		
		for(int i : input) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i)+1);
			}
		}
		
		Comparator<int[]> c = (a,b)-> b[0] - a[0];
		PriorityQueue<int[]> pq = new PriorityQueue<>(c);
		for(int i : map.keySet()) {
			int key = i;
			int val = map.get(i);
			int[] temp = new int[] {key,val};
			pq.add(temp);
		}
		
		int result = 0;
		
		while(pq.size()>1) {
			int[] first = pq.poll();
			int[] second = pq.poll();
			result= result + first[1];
			second[1] = second[1] + first[1];
			pq.add(second);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4};
		System.out.println(min(input));

	}

}
