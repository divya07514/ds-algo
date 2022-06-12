package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MeetingRooms {

	public static boolean canAttendMeetings(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return true;
		}

		Comparator<int[]> c = (a, b) -> a[0] < b[0] ? -1 : a[0] - b[0] == 0 ? 0 : 1;
		Collections.sort(Arrays.asList(intervals), c);

		int[] start = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] current = intervals[i];
			if (current[0] < start[1]) {
				return false;
			}
			start = current;
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		System.out.println(canAttendMeetings(intervals));

	}

}
