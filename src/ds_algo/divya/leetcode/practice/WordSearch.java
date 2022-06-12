package ds_algo.divya.leetcode.practice;

public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}
		char[] array = word.toCharArray();
		int start = 0;
		int r = board.length;
		int c = board[0].length;
		boolean[][] isVisited = new boolean[r][c];
		boolean result = false;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == array[0] && !result) {
					result = search(i, j, board, isVisited, start, array);
				}
			}
			if (result) {
				break;
			}
		}
		return result;
	}

	private static boolean search(int i, int j, char[][] board, boolean[][] isVisited, int start, char[] array) {
		if(start==array.length) {
			return true;
		}
		if(i<0 || i>=board.length || j < 0 || j>=board[0].length) {
			return false;
		}
		if(board[i][j]!=array[start] || isVisited[i][j]) {
			return false;
		}
		isVisited[i][j] = true;
		
		if(			search(i+1, j, board, isVisited, start+1, array) 
				|| 	search(i-1, j, board, isVisited, start+1, array)
				|| 	search(i, j+1, board, isVisited, start+1, array)
				|| 	search(i, j-1, board, isVisited, start+1, array)) {
			return true;
		}
		isVisited[i][j] = false;
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { 
				{ 'A', 'B', 'C', 'E' }, 
				{ 'S', 'F', 'C', 'S' }, 
				{ 'A', 'D', 'E', 'E' } };
		String word = "ABA";
		System.out.println(exist(board, word));
	}

}
