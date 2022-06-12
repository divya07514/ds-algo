package ds_algo.divya.leetcode.practice;

public class MaxConsecutiveOnes3 {

	static public int longestOnes(int[] A, int K) {
		int maxLength = 0;
		for (int i = 0, j = 0; j < A.length; j++) {
			if (A[j] == 0) {
				K--;
			}
			while (K < 0) {
				if (A[i] == 0) {
					K++;
				}
				i++;
			}
			maxLength = Math.max(maxLength, j - i + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int K = 2;
		System.out.println(longestOnes(A, K));
	}

}
