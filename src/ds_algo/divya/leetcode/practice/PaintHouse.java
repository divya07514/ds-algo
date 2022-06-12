package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class PaintHouse {

	public static int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int r = costs.length;
		int c = costs[0].length;
		for (int i = r - 2; i >= 0; i--) {
			for (int j = 0; j < c; j++) {
				if (j == 0) {
					int current = costs[i][j];
					int right = costs[i + 1][j + 1];
					int rightright = costs[i + 1][j + 2];
					costs[i][j] = Math.min(current + right, current + rightright);
				} else if (j == c - 1) {
					int current = costs[i][j];
					int left = costs[i + 1][j - 1];
					int leftleft = costs[i + 1][j - 2];
					costs[i][j] = Math.min(current + left, current + leftleft);
				} else {
					int current = costs[i][j];
					int left = costs[i + 1][j - 1];
					int right = costs[i + 1][j + 1];
					costs[i][j] = Math.min(current + left, current + right);
				}

			}
		}
		int[] temp = costs[0];
		Arrays.sort(temp);
		return temp[0];
	}


	public static void main(String[] args) {
		int[][] costs = { 
							{ 3, 5, 3 }, 
							{ 6, 17, 6 }, 
							{ 7, 13, 18 }, 
							{ 9, 10, 18 } 
				};
		System.out.println(minCost(costs));
	}

}
