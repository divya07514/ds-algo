package ds_algo.divya.leetcode.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementinaSortedMatrix {

	public static int kthSmallest(int[][] matrix, int k) {
		if (matrix == null) {
			return 0;
		}

		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(c);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (k == 0) {
					if (maxHeap.peek() > matrix[i][j]) {
						maxHeap.poll();
						maxHeap.add(matrix[i][j]);
					}
				} else {
					maxHeap.add(matrix[i][j]);
					k--;
				}
			}
		}
		return maxHeap.poll();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int k = 4;
		System.out.println(kthSmallest(matrix, k));

	}

}
