package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class IntersectionofThreeSortedArrays {
	
	public static List<Integer> intersection(int[] ar1, int[] ar2, int[] ar3){
		
		int i =0;
		int j=0;
		int k=0;
		List<Integer> list = new ArrayList<Integer>();
		while(i < ar1.length && j<ar2.length && k<ar3.length) {
			
			if(ar1[i]==ar2[j] && ar2[j]==ar3[k]) {
				list.add(ar1[i]);
				i++;
				j++;
				k++;
			}else if(ar1[i] < ar2[j]) {
				i++;
			}else if(ar2[j]<ar3[k]) {
				j++;
			}else {
				k++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int ar1[] = {1, 5, 10, 20, 40, 80}; 
        int ar2[] = {6, 7, 20, 80, 100}; 
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}; 
        
        System.out.println(intersection(ar1, ar2, ar3));

	}

}
