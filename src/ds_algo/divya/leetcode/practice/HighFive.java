package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
	public int[][] highFive(int[][] items) {

		int r = items.length;
		int c = items[0].length;

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		Comparator<Integer> cmp = (a, b) -> b - a;
		for (int i = 0; i < r; i++) {
			int[] temp = items[i];
			int id = temp[0];
			int score = temp[1];
			if (!map.containsKey(id)) {
				PriorityQueue<Integer> q = new PriorityQueue<>(cmp);
				q.add(score);
				map.put(id, q);
			} else {
				map.get(id).add(score);
			}
		}

		
		
		int index = 0;
		int[][] result = new int[map.size()][1];
		for (int key : map.keySet()) {
			PriorityQueue<Integer> q = map.get(key);
			int count = 0;
			int sum = 0;
			while (count < 5) {
				sum = sum + q.poll();
				count++;
			}
			int avg = sum / 5;
			int[] temp = new int[] { key, avg };
			result[index++] = temp;
		}

		Comparator<int[]> comp = (a, b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		Collections.sort(Arrays.asList(result), comp);
		return result;
	}
}
