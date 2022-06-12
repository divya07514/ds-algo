package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	
	/**
	 * Self implemented solution
	 * @param intervals
	 * @return
	 */
	public static int[][] merge(int[][] intervals) {
		List<Interval> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			Interval it = new Interval();
			it.start = intervals[i][0];
			it.end = intervals[i][1];
			list.add(it);
		}
		Comparator<Interval> comp = (a, b) -> a.end - b.end;
		list.sort(comp);
		int i = 0;
		while (i < list.size() - 1) {
			Interval one = list.get(i);
			Interval two = list.get(i + 1);
			if (one.end >= two.start && one.end <= two.end) {
				Interval temp = new Interval();
				temp.end = two.end;
				temp.start = one.start < two.start ? one.start : two.start;
				list.remove(i);
				list.remove(i);
				list.add(i, temp);
				i = 0;
			} else {
				i++;
			}
		}
		i = 0;
		int[][] result = new int[list.size()][2];
		for (; i < list.size(); i++) {
			Interval it = list.get(i);
			result[i][0] = it.start;
			result[i][1] = it.end;
		}
		return result;
	}

	/**
	 * Leetcode Solution
	 * @param intervals
	 * @return
	 */
	public static int[][] merge_leetcode(int[][] intervals) {
		LinkedList<int[]> list = new LinkedList<>();
		Comparator<int[]> comp = (a, b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		Collections.sort(Arrays.asList(intervals), comp);
		for (int[] interval : intervals) {
			if (list.isEmpty() || list.getLast()[1] < interval[0]) {
				list.add(interval);
			} else {
				list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
			}
		}
		return list.toArray(new int[list.size()][]);
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 15, 18 }, { 8, 10 } };
		ArrayUtil.print(merge(intervals));
		ArrayUtil.print(merge_leetcode(intervals));
	}

}

class Interval {
	int start;
	int end;
	
	public Interval() {
	}

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public String toString() {
		return start + "," + end;
	}
}
