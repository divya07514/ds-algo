package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class KthUglyNumber {

	public static int nthUglyNumber(int n) {
		if(n < 0) {
			return 0;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		int idx2=0;
		int idx3=0;
		int idx5=0;
		
		while(list.size() < n) {
			int by2 = list.get(idx2)*2;
			int by3 = list.get(idx3)*3;
			int by5 = list.get(idx5)*5;
			
			int min = Math.min(by2, Math.min(by3, by5));
			list.add(min);
			
			if(min==by2) idx2++;
			if(min==by3) idx3++;
			if(min==by5) idx5++;
		}
		
		
		
		return list.get(list.size()-1);
	}

	public static void main(String[] args) {
		int n=11;
		System.out.println(nthUglyNumber(n));

	}

}
