package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBinaryMatrix_Ext {
	


	public static void main(String[] args) {
		ShortestPathBinaryMatrix_Ext solver = new ShortestPathBinaryMatrix_Ext();
		int[][] grid = {
				{ 0, 1, 1, 0 },
				{ 0, 0, 0, 1 },
				{ 1, 1, 0, 1 },
				{ 0, 0, 0, 0 } };

		List<int[]> path = solver.shortestPathBinaryMatrix(grid);
		if (path.isEmpty()) {
			System.out.println("No path found");
		} else {
			System.out.println("Shortest path:");
			for (int[] step : path) {
				System.out.println("[" + step[0] + ", " + step[1] + "]");
			}
		}
	}

	private List<int[]> shortestPathBinaryMatrix(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		if (r == 0 && c == 0) {
			return new ArrayList();
		}
		if (grid[0][0] != 0 || grid[r - 1][c - 1] != 0) {
			return new ArrayList();
		}

		LinkedList<PathNode> q = new LinkedList();
		List<int[]> startPath = new ArrayList();
		startPath.add(new int[] { 0, 0 });
		PathNode start = new PathNode(0, 0, startPath);
		q.add(start);

		int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				PathNode temp = q.poll();

				if (temp.x == r - 1 && temp.y == c - 1) {
					return temp.path;
				}

				for (int[] d : dirs) {
					int nx = temp.x + d[0];
					int ny = temp.y + d[1];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || grid[nx][ny] != 0) {
						continue;
					}
					List<int[]> newPath = new ArrayList(temp.path);
					newPath.add(new int[] { nx, ny });
					q.add(new PathNode(nx, ny, newPath));
					grid[nx][ny] = 1;
				}

				qs--;
			}
		}

		return new ArrayList();
	}
}

class PathNode {
	int x;
	int y;
	List<int[]> path;

	public PathNode(int x, int y, List<int[]> path) {
		this.x = x;
		this.y = y;
		this.path = path;
	}

	@Override
	public String toString() {
		return "PathNode [x=" + x + ", y=" + y + ", path=" + path + "]";
	}
	
}
