package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

		if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
			return new int[0][0];
		}

		List<int[]> result = new ArrayList();
		int i = 0;
		int j = 0;

		while (i < firstList.length && j < secondList.length) {
			int[] one = firstList[i];
			int[] two = secondList[j];

			int lo = Math.max(one[0], two[0]);
			int hi = Math.min(one[1], two[1]);
			if (lo <= hi) {
				result.add(new int[] { lo, hi });
			}
			if (one[1] > two[1]) {
				j++;
			} else {
				i++;
			}
		}

		return result.toArray(new int[result.size()][]);
	}

}
