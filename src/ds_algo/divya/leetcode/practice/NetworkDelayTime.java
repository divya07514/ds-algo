package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
	public static int networkDelayTime(int[][] times, int n, int k) {

		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int[] i : times) {
			int src = i[0];
			if (!map.containsKey(src)) {
				List<int[]> list = new ArrayList<>();
				int[] temp = new int[2];
				temp[0] = i[1];
				temp[1] = i[2];
				list.add(temp);
				map.put(src, list);
			} else {
				int[] temp = new int[2];
				temp[0] = i[1];
				temp[1] = i[2];
				map.get(src).add(temp);
			}
		}

		boolean[] marked = new boolean[n + 1];
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);

		Comparator<int[]> c = (a, b) -> a[0] - b[0];
		PriorityQueue<int[]> pq = new PriorityQueue<>(c);

		int[] start = new int[2];
		start[0] = 0;
		start[1] = k;
		pq.add(start);
		minDist[k] = 0;
		int result = 0;

		while (!pq.isEmpty()) {

			int[] temp = pq.poll();
			int current = temp[1];
			if (marked[current]) {
				continue;
			}

			marked[current] = true;
			int currentDist = temp[0];
			result = currentDist;
			n--;

			if (!map.containsKey(current)) {
				continue;
			} else {
				for (int[] next : map.get(current)) {
					int nextNode = next[0];
					int nextDist = next[1];

					if (!marked[nextNode] && nextDist + currentDist < minDist[nextNode]) {
						int[] minNode = new int[2];
						minNode[0] = nextDist + currentDist;
						minNode[1] = nextNode;
						minDist[nextNode] =  nextDist + currentDist;
						pq.add(minNode);
					}

				}
			}

		}

		return n == 0 ? result : -1;

	}

	public static void main(String[] args) {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int N = 4;
		int K = 2;
		System.out.println(networkDelayTime(times, N, K));
	}

}
