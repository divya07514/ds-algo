package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {

	public static int minMeetingRooms(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			int[] temp = intervals[i];
			int peek = pq.peek();
			if (temp[0] >= peek) {
				pq.poll();
				pq.add(temp[1]);
			} else {
				pq.add(temp[1]);
			}

		}

		return pq.size();
	}

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(minMeetingRooms(intervals));

	}

}
