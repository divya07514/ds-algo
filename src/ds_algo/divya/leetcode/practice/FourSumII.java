package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				if (!map.containsKey(sum)) {
					map.put(sum, 1);
				} else {
					map.put(sum, map.get(sum) + 1);
				}
			}
		}
		int count = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				int diff = 0 - (sum);
				if (map.containsKey(diff)) {
					count = count + map.get(diff);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] A = { -1, -1 };
		int[] B = { -1, 1 };
		int[] C = { -1, 1 };
		int[] D = { 1, -1 };
		System.out.println(fourSumCount(A, B, C, D));
	}

}
