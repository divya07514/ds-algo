package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LastStoneWeight {

	public static int lastStoneWeight(int[] stones) {
		if(stones==null || stones.length==0) {
			return 0;
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i : stones) {
			list.add(i);
		}
		Comparator<Integer> c =  new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		while(list.size()>1) {
			list.sort(c);
			int one = list.get(0);
			int two = list.get(1);
			if(one==two) {
				list.remove(0);
				list.remove(0);
			}else {
				list.add(Math.abs(two-one));
				list.remove(0);
				list.remove(0);
			}
		}
		if(list.isEmpty()) {
			return 0;
		}else {
			return list.get(0);
		}
	}

	public static void main(String[] args) {
		int[] stones = { 2,2};
		System.out.println(lastStoneWeight(stones));

	}

}
