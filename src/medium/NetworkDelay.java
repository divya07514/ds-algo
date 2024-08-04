package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelay {

	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> map = new HashMap();
		for (int[] i : times) {
			int s = i[0];
			int t = i[1];
			int time = i[2];
			int[] temp = new int[] { t, time };// (node, dist)
			if (!map.containsKey(s)) {
				List<int[]> list = new ArrayList();
				list.add(temp);
				map.put(s, list);
			} else {
				map.get(s).add(temp);
			}
		}
		if (!map.containsKey(k)) {
			return -1;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		int[] result = new int[n + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[k] = 0;
		pq.add(new int[] { 0, k });// (dist,node)
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int dist = temp[0];
			int node = temp[1];
			if (map.containsKey(node)) {
				for (int[] i : map.get(node)) {
					int neib = i[0];
					int wt = i[1];
					if (wt + dist < result[neib]) {
						result[neib] = wt + dist;
						pq.add(new int[] { wt + dist, neib });
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (result[i] == Integer.MAX_VALUE) {
				return -1;
			}
			max = Math.max(max, result[i]);
		}

		return max;
	}

}
