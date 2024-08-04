package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	public static int minMeetingRooms(int[][] nums) {

		if (nums.length == 1) {
			return 1;
		}

		Arrays.sort(nums, (a, b) -> a[0] - b[0]);

		Comparator<int[]> c = (a, b) -> a[1] - b[1];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(c);
		pq.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int[] current = nums[i];
			int start = current[0];
			int end = current[1];

			if (!pq.isEmpty() && pq.peek()[1] <= start) {
				pq.poll();
			}
			pq.add(current);
		}

		return pq.size();
	}

	public static void main(String[] args) {
		int[][] nums = {{0,30},{5,10},{15,20},{5,13},{20,25},{20,23},{12,16}};
		System.out.println(minMeetingRooms(nums));

	}

}
