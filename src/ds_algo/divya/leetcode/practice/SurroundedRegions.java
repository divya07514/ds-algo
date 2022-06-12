package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
	
	static	int r;
	static  int c;
	
	public static void solve(char[][] board) {
		if(board==null || board.length==0) {
			return;
		}
		 r = board.length;
		 c = board[0].length;
		boolean[][] marked = new boolean[r][c];
		List<String> list = new ArrayList<>();
		
		//top
		for(int i=0;i<c;i++) {
			if(board[0][i]=='O' && !marked[0][i]) {
				connected(0,i,marked,list,board);
			}
		}
		//bottom
		for(int i=0;i<c;i++) {
			if(board[r-1][i]=='O' && !marked[r-1][i]) {
				connected(r-1,i,marked,list,board);
			}
		}
		
		//left
		for(int i=0;i<r;i++) {
			if(board[i][0]=='O' && !marked[i][0]) {
				connected(i,0,marked,list,board);
			}
		}
		
		//right
		for(int i=0;i<r;i++) {
			if(board[i][c-1]=='O' && !marked[i][c-1]) {
				connected(i,c-1,marked,list,board);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				String key = "("+i+","+j+")";
				if(!list.contains(key)) {
					board[i][j]='X';
				}
			}
		}
		
	}

	private static void connected(int x, int y, boolean[][] marked, List<String> list, char[][] board) {
		if(x < 0 || x >= r || y < 0 || y >= c) {
			return;
		}
		if(marked[x][y]) {
			return;
		}
		if(board[x][y]!='O') {
			return;
		}
		marked[x][y]=true;
		list.add("("+x+","+y+")");
		connected(x-1, y, marked, list, board);
		connected(x+1, y, marked, list, board);
		connected(x, y-1, marked, list, board);
		connected(x, y+1, marked, list, board);
	}
	


	public static void main(String[] args) {
			char[][] board = {
								{'X','X','X','X'},
								{'X','O','O','X'},
								{'X','X','O','X'},
								{'X','O','X','X'}
							};

			solve(board);
			ArrayUtil.print(board);
	}

}
	
