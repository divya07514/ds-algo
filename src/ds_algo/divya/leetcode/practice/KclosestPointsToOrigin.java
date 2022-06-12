package ds_algo.divya.leetcode.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KclosestPointsToOrigin {

	public static int[][] kClosest(int[][] points, int K) {
		if (points == null) {
			return new int[1][1];
		}
		Comparator<Pair> comparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				double distOne = Math.sqrt(Math.pow(o1.x, 2) + Math.pow(o1.y, 2));
				double distTwo = Math.sqrt(Math.pow(o2.x, 2) + Math.pow(o2.y, 2));
				if (distOne < distTwo) {
					return -1;
				} else if (distOne > distTwo) {
					return 1;
				}
				if (o1.x == o2.y && o1.y == o2.x) {
					return -1;
				}
				return 0;
			}
		};
		PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
		populateQueue(points, pq);
		int[][] result = new int[K][2];

		for (int i = 0; i < K; i++) {
			Pair p = pq.poll();
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		return result;
	}

	public static void populateQueue(int[][] points, PriorityQueue<Pair> pq) {
		for (int i = 0; i < points.length; i++) {
			Pair p = new Pair();
			p.x = points[i][0];
			p.y = points[i][1];
			pq.add(p);
		}
	}

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };

		int[][] result = kClosest(points, 2);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
		}

	}

}
