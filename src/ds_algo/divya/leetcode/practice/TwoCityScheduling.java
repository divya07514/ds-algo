package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class TwoCityScheduling {

	public static int twoCitySchedCost(int[][] costs) {
		if (costs.length == 0) {
			return 0;
		}
		int result = 0;
		int cities = costs.length;

		for (int i = 0; i < cities; i++) {
			result = result + costs[i][0];
		}

		int[] diff = new int[cities];

		for (int i = 0; i < diff.length; i++) {
			diff[i] = costs[i][1] - costs[i][0];
		}
		Arrays.sort(diff);

		for (int i = 0; i < cities / 2; i++) {
			result = result + diff[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] costs = { { 184, 139 }, { 259, 770 }, { 448, 54 }, { 577, 469 }, { 840, 118 }, { 926, 667 } };
		System.out.println(twoCitySchedCost(costs));

	}

}
