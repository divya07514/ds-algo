package ds_algo.divya.leetcode.practice;

public class PathWithMinimumEffort {
	
	 static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	    public static int minimumEffortPath(int[][] heights) {
	        int left  = 0;
	        int right = 1000000;
	        int result = right;
	        while(left<=right){
	            int mid = (left+right)/2;
	            if(dfsUtil(heights,mid)){
	                result = mid;
	                right = mid -1;
	            }else{
	                
	                left= mid + 1;
	            }
	        }
	        return result;
	    }
	    
	    public static boolean dfsUtil(int[][] grid, int mid){
	        boolean[][] marked = new boolean[grid.length][grid[0].length];
	        int i=0;
	        int j = 0;
	        return dfs(i,j,mid,grid,marked);
	    }
	    
	    public static boolean dfs(int i, int j, int mid, int[][] grid, boolean[][] marked){
	        if(i==grid.length -1 && j==grid[0].length -1){
	            return true;
	        }
	        marked[i][j]=true;
	        for(int[] dir : directions){
	            int nr = i + dir[0];
	            int nc = j + dir[1];
	            if(nr<0 || nr>=grid.length || nc<0 || nc >= grid[0].length || marked[nr][nc]){
	                continue;
	            }
	            int currentDiff = Math.abs(grid[nr][nc] - grid[i][j]);
	            if(currentDiff<=mid){
	                if(dfs(nr,nc,mid,grid,marked)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	public static void main(String[] args) {
		int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
		System.out.println(minimumEffortPath(heights));

	}

}
