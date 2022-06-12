package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {

	public static int maximumUnits(int[][] boxTypes, int truckSize) {

		Comparator<int[]> c = (a, b) -> {
			return b[1] - a[1];
		};

		int result = 0;
		Arrays.sort(boxTypes, c);
		for (int[] temp : boxTypes) {
			if (truckSize == 0) {
				break;
			}
			int box = temp[0];
			int count = temp[1];
			if (box < truckSize) {
				truckSize = truckSize - box;
				int total = box * count;
				result = result + total;
			} else {
				int total = truckSize * count;
				result = result + total;
				truckSize = 0;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] boxTypes = {{1,3},{2,2},{3,1}};
		int truckSize = 4;
		System.out.println(maximumUnits(boxTypes, truckSize));
	}

}
