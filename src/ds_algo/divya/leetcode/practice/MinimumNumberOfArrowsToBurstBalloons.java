package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MinimumNumberOfArrowsToBurstBalloons {
	
	public static int findMinArrowShots(int[][] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 0) {
			return 1;
		}

		Comparator<int[]> c = (a, b) -> {

			return a[0] == b[0] ? 0 : a[0] > b[0] ? 1 : -1;
		};

		Arrays.sort(nums, c);

		LinkedList<int[]> list = new LinkedList<>();

		for (int[] a : nums) {
			if (list.isEmpty()) {
				list.add(a);
				continue;
			}
			int[] last = list.getLast();

			if (list.isEmpty() || last[1] >= a[0]) {
				last[0] = Math.max(last[0], a[0]);
				last[1] = Math.min(last[1], a[1]);
			} else {
				list.add(a);
			}
		}

		return list.size();
	}

	public static void main(String[] args) {
		int[][] nums = {{10,16},{2,8},{1,6},{7,12}};
		System.out.println(findMinArrowShots(nums));

	}

}
