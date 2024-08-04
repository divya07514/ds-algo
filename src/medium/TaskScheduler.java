package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static int leastInterval(char[] tasks, int n) {

		Map<Character, Integer> map = new HashMap();

		for (char c : tasks) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		Comparator<Integer> comp = (a, b) -> b - a;
		PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
		pq.addAll(map.values());
		List<int[]> list = new ArrayList();
		int time = 0;

		while (!pq.isEmpty() || !list.isEmpty()) {
			time = time + 1;
			if (!pq.isEmpty()) {
				int i = pq.poll() - 1;
				if (i > 0) {
					int[] temp = new int[] { i, time + n };
					list.add(temp);
				}
			}
			if (!list.isEmpty() && list.get(0)[1] == time) {
				pq.add(list.remove(0)[0]);
			}
		}
		return time;
	}

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));

	}

}
