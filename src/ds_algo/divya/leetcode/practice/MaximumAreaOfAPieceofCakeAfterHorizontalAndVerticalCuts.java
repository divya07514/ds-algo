package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class MaximumAreaOfAPieceofCakeAfterHorizontalAndVerticalCuts {

	public static int maxArea(int h, int w, int[] ho, int[] ve) {
		Arrays.sort(ho);
		Arrays.sort(ve);

		long maxR = ho[0], maxC = ve[0];
		for (int i = 1; i < ho.length; i++) {
			maxR = Math.max(maxR, ho[i] - ho[i - 1]);
		}

		maxR = Math.max(maxR, h - ho[ho.length - 1]);

		for (int i = 1; i < ve.length; i++) {
			maxC = Math.max(maxC, ve[i] - ve[i - 1]);
		}

		maxC = Math.max(maxC, w - ve[ve.length - 1]);

		System.out.println(maxC + " " + maxR);
		return (int) ((maxR * maxC) % (1000000000 + 7));
	}

	public static void main(String[] args) {
		int h = 5, w = 4;
		int[] horizontalCuts = { 3, 1 };
		int[] verticalCuts = { 1 };
		System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));

	}

}
