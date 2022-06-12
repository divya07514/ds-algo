package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class InsertInterval {

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		
		LinkedList<int[]> list = new LinkedList<>();
		if (intervals == null || intervals.length == 0) {
			int[][] result = new int[1][1];
			result[0] = newInterval;
			return result;
		}

		int i = 0;
		int newStart = newInterval[0];
		int newEnd = newInterval[1];
		while (i < intervals.length && newStart > intervals[i][0]) {
			list.add(intervals[i++]);
		}

		if (list.isEmpty() || list.getLast()[1] < newStart) {
			list.add(newInterval);
		} else {
			int[] interval = list.removeLast();
			interval[1] = Math.max(interval[1], newEnd);
			list.add(interval);
		}

		while (i < intervals.length) {
			int[] last = list.getLast();
			int[] temp = intervals[i];
			if (temp[0] <= last[1]) {
				last[1] = Math.max(last[1], temp[1]);
			} else {
				list.add(temp);
			}
			i++;
		}

		return list.toArray(new int[list.size()][]);

	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };
		int[][] result = insert(intervals, newInterval);
		ArrayUtil.print(result);

	}

}
