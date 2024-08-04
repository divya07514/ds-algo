package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Do BFS traversal and maintain separate maps of [node, distance] from the given node.
 * Iterate over all the nodes and check if a node is present in both the maps
 * Keep minimizing the max distance and store the node for which this happens
 * @author divya.thakur
 *
 */
public class FindClosestNodetoGivenTwoNodes {

	public int closestMeetingNode(int[] edges, int node1, int node2) {
		if (edges == null || edges.length == 0) {
			return 0;
		}
		Map<Integer, Integer> one = new HashMap();
		Map<Integer, Integer> two = new HashMap();

		bfs(node1, one, edges);
		bfs(node2, two, edges);

		int node = -1;
		int max = Integer.MAX_VALUE;

		System.out.println(one);
		System.out.println(two);

		for (int i = 0; i < edges.length; i++) {
			if (one.containsKey(i) && two.containsKey(i)) {
				int dist = Math.max(one.get(i), two.get(i));
				if (dist < max) {
					max = dist;
					node = i;
				}
			}
		}
		return node;
	}

	private void bfs(int node, Map<Integer, Integer> map, int[] edges) {
		LinkedList<Integer> q = new LinkedList();
		boolean[] marked = new boolean[edges.length];
		int dist = 0;
		q.add(node);
		marked[node] = true;
		map.put(node, 0);
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int temp = q.poll();
				int next = edges[temp];
				if (next != -1 && !marked[next]) {
					map.put(next, dist + 1);
					marked[next] = true;
					q.add(next);
				}
				qs--;
			}
			dist = dist + 1;
		}

	}

}
