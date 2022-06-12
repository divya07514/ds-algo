package ds_algo.divya.leetcode.practice;

public class TheMaze {

	static int[][] dirs = new int[][]{ { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return dfs(maze, start, destination, visited);
	}

	private static boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
		if (visited[start[0]][start[1]]) {
			return false;
		}
		if (start[0] == destination[0] && start[1] == destination[1]) {
			return true;
		}
		visited[start[0]][start[1]] = true;
		for (int i = 0; i < dirs.length; i++) {
			int[] d = dirs[i];
			int row = start[0];
			int col = start[1];
			while (isValid(maze, row + d[0], col + d[1])) {
				row += d[0];
				col += d[1];
			}
			if (dfs(maze, new int[] { row, col }, destination, visited)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isValid(int[][] maze, int row, int col) {
		return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != 1;
	}

	public static void main(String[] args) {
		int[][] maze = { 
							{ 0, 0, 1, 0, 0 }, 
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 1, 0 }, 
							{ 1, 1, 0, 1, 1 },
							{ 0, 0, 0, 0, 0 } 
						};
		
		int[] start = { 0, 4 };
		int[] dest = { 4, 4 };
		System.out.println(hasPath(maze, start, dest));
	}

}
