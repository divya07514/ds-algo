package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberofArrowstoBurstBalloons {

	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		Arrays.sort(points, (a, b) -> a[0] - b[0]);

		Comparator<int[]> c = (a, b) -> b[0] - a[0];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(c);

		for (int[] i : points) {
			if (pq.isEmpty()) {
				pq.add(i);
			} else {
				int[] top = pq.poll();
				if (i[0] >= top[0] && i[0] <= top[1]) {
					int[] temp = new int[2];
					temp[0] = Math.max(i[0], top[0]);
					temp[1] = Math.min(i[1], top[1]);
					System.out.println(temp[0] + ", " + temp[1]);
					pq.add(temp);
				} else {
					pq.add(top);
					pq.add(i);
				}
			}
		}

		return pq.size();

	}
	
    public int findMinArrowShots_leetcode(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];

            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }
        return arrows;
    }

}
