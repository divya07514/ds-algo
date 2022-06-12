package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class MergerTwoSortedArrays {
	
	public static int[] mergeArrays(int[] a, int[] b) {
		int[] result = new int[a.length+b.length];
		
		int idx=0;
		for(int i=0;i<a.length;i++) {
			result[idx] = a[i];
			idx++;
		}
		for(int i=0;i<b.length;i++) {
			result[idx] = b[i];
			idx++;
		}
		Arrays.sort(result);
		return result;
	}

	public static void main(String[] args) {
	int[] a = {1,5,7,7};
	int[] b = {0,1,2,3};
	ArrayUtil.printArray(mergeArrays(a, b));

	}

}
