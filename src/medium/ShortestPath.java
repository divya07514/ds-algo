package medium;

import java.util.LinkedList;

public class ShortestPath {

	public static int shortestBridge(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;	
		boolean found = false;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1) {
					dfs(i, j, r, c, grid);
                    found=true;
				}
	            if(found){
	                break;
	            }
			}
            if(found){
                break;
            }
		}
		LinkedList<int[]> q = new LinkedList();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}
		int level = 0;
		found = false;
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] marked = new boolean[r][c];
		
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				//System.out.println("curr "+ x+", "+y);
				if (grid[x][y] == 2) {
					found = true;
					break;
				}
				for (int[] i : dirs) {
					int nx = x + i[0];
					int ny = y + i[1];
					if (nx >= 0 && nx < r && ny >= 0 && ny < c && !marked[nx][ny] && grid[nx][ny]!=1) {
						//System.out.println("add "+ nx+", "+ny);
						q.add(new int[] { nx, ny });
						marked[nx][ny]=true;
					}
				}
				qs--;
			}
			if (found) {
				break;
			}
			level++;
		}

		return level-1;

	}

	private static void dfs(int i, int j, int r, int c, int[][] grid) {
		if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 2 || grid[i][j]==0) {
			return;
		}
		grid[i][j] = 2;
		dfs(i + 1, j, r, c, grid);
		dfs(i - 1, j, r, c, grid);
		dfs(i, j + 1, r, c, grid);
		dfs(i, j - 1, r, c, grid);
	}

	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,1},{0,1,1,0,1},{0,1,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
		System.out.println(shortestBridge(grid));

	}	

}
