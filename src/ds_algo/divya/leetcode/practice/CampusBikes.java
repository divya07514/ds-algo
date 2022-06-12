package ds_algo.divya.leetcode.practice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBikes {

	public static int[] assignBikes(int[][] workers, int[][] bikes) {
		Comparator<int[]> comp = getComparator();
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(comp);

		for (int i = 0; i < workers.length; i++) {
			int[] worker = workers[i];
			for (int j = 0; j < bikes.length; j++) {
				int[] bike = bikes[j];
				int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
				int[] value = new int[] { i, j, dist };
				q.add(value);
			}
		}

		int[] result = new int[workers.length];
		Set<Integer> markedWorker = new HashSet<Integer>();
		Set<Integer> markedBike = new HashSet<Integer>();
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (!markedWorker.contains(temp[0]) && !markedBike.contains(temp[1])) {
				result[temp[0]] = temp[1];
				markedWorker.add(temp[0]);
				markedBike.add(temp[1]);
			}
		}

		return result;
	}

	private static Comparator<int[]> getComparator() {
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[2] < b[2]) { // distance comparison
					return -1;
				}
				if (a[2] == b[2]) {
					if (a[0] != b[0]) { // worker index comparison
						return a[0] - b[0];
					} else {
						return a[1] - b[1]; // bike index comparison
					}
				}

				return 1;
			}
		};
		return comp;
	}

	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
		int[][] bikes = { { 1, 0 }, { 2, 2 }, { 2, 1 } };
		ArrayUtil.printArray(assignBikes(workers, bikes));
	}

}
