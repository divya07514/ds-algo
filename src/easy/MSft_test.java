package easy;

import java.util.ArrayList;
import java.util.List;

public class MSft_test {

		public static boolean solution(int N, int[] A, int[] B) {
			// Create an adjacency list to represent the graph
			List<List<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}

			// Add edges to the adjacency list
			for (int i = 0; i < A.length; i++) {
				adjList.get(A[i]).add(B[i]);
				adjList.get(B[i]).add(A[i]); // Since the graph is undirected
			}

			// Perform DFS starting from vertex 1
			boolean[] visited = new boolean[N + 1];
			if (!dfs(adjList, 1, visited, 1)) {
				return false;
			}

			// Check if all vertices are visited
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					return false;
				}
			}

			return true;
		}

		private static boolean dfs(List<List<Integer>> adjList, int vertex, boolean[] visited, int count) {
			if (visited[vertex]) {
				return false;
			}

			visited[vertex] = true;

			// Check if the current vertex count is equal to the total number of vertices
			if (count == adjList.size() - 1) {
				return true;
			}

			// Recursively visit unvisited neighbors
			for (int neighbor : adjList.get(vertex)) {
				if (dfs(adjList, neighbor, visited, count + 1)) {
					return true;
				}
			}

			return false;
		}

	public static void main(String[] args) {
		System.out.println(solution(4, new int[]{1, 2, 4, 4, 3}, new int[]{2, 3, 1, 3, 1})); // Output: true
		System.out.println(solution(4, new int[]{1, 2, 1, 3}, new int[]{2, 4, 3, 4})); // Output: false

	}

}
