package ds_algo.divya.leetcode.practice;

public class NumberOfIslands {
	
	static int result;
    public static int numIslands(char[][] grid) {
        result = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] marked = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !marked[i][j]){
                    System.out.println(i+", "+j);
                    dfs(i,j,grid,marked);
                    result++;
                }
            }
        }

        return result;
    }
    
    public static void dfs(int i, int j, char[][] grid, boolean[][] marked){
        if(i < 0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0' || marked[i][j]){
            return;
        }
        marked[i][j] = true;
        dfs(i+1,j,grid,marked);
        dfs(i-1,j,grid,marked);
        dfs(i,j+1,grid,marked);
        dfs(i,j-1,grid,marked);
    }

	public static void main(String[] args) {
		char [][] grid = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','1'}
				};
		System.out.println(numIslands(grid));

	}

}
