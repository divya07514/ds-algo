package medium;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {
	
	public List<Integer> eventualSafeNodes(int[][] graph) {

		boolean[] onstack = new boolean[graph.length];
		boolean[] visited = new boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			dfs(i, onstack, visited, graph);
		}
		List<Integer> list = new ArrayList();

		for (int i = 0; i < onstack.length; i++) {
			if (!onstack[i]) {
				list.add(i);
			}
		}

		return list;

	}

	private boolean dfs(int s, boolean[] onstack, boolean[] visited, int[][] graph) {
		if (onstack[s]) {
			return true;
		}
		if (visited[s]) {
			return false;
		}
		onstack[s] = true;
		visited[s] = true;
		for (int i : graph[s]) {
			if (dfs(i, onstack, visited, graph)) {
				return true;
			}
		}
		onstack[s] = false;
		return false;
	}
}
