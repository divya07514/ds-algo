package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SlidingPuzzle {

	public static int slidingPuzzle(int[][] grid) {

		String resultKey = "[[1, 2, 3], [4, 5, 0]]";
		
		if(Arrays.deepToString(grid).equals(resultKey)) {
			return 0;
		}
		
		int count = 0;

		int posi = 0;
		int posj = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					posi = i;
					posj = j;
					break;
				}
			}
		}
		Set<String> marked = new HashSet<String>();
		LinkedList<PuzzleNode> q = new LinkedList<>();
		PuzzleNode root = new PuzzleNode(grid, posi, posj);
		q.add(root);
		while (!q.isEmpty()) {
			int qs = q.size();

			while (qs > 0) {
				PuzzleNode temp = q.poll();
				if (valid(temp.grid, temp.i + 1, temp.j)) {
					PuzzleNode down = getNode(temp.i, temp.j, temp.i + 1, temp.j, temp);
					if (down.boardString.equals(resultKey)) {
						return count + 1;
					}
					if(!marked.contains(down.boardString)) {
						q.add(down);
						marked.add(down.boardString);
					}
				}

				if (valid(temp.grid, temp.i - 1, temp.j)) {
					PuzzleNode up = getNode(temp.i, temp.j, temp.i - 1, temp.j, temp);
					if (up.boardString.equals(resultKey)) {
						return count + 1;
					}
					if(!marked.contains(up.boardString)) {
						q.add(up);
						marked.add(up.boardString);
					}
				}

				if (valid(temp.grid, temp.i, temp.j - 1)) {
					PuzzleNode left = getNode(temp.i, temp.j, temp.i, temp.j - 1, temp);
					if (left.boardString.equals(resultKey)) {
						return count + 1;
					}
					if(!marked.contains(left.boardString)) {
						q.add(left);
						marked.add(left.boardString);
					}
				}

				if (valid(temp.grid, temp.i, temp.j + 1)) {
					PuzzleNode right = getNode(temp.i, temp.j, temp.i, temp.j + 1, temp);
					if (right.boardString.equals(resultKey)) {
						return count + 1;
					}
					if(!marked.contains(right.boardString)) {
						q.add(right);
						marked.add(right.boardString);
					}
				}

				qs--;
			}
			count++;
		}

		return -1;

	}

	public static PuzzleNode getNode(int oldi, int oldj, int newi, int newj, PuzzleNode temp) {
		int[][] state = copy(temp.grid);
		int swap = state[oldi][oldj];
		state[oldi][oldj] = state[newi][newj];
		state[newi][newj] = swap;
		PuzzleNode up = new PuzzleNode(state, newi, newj);
		return up;
	}

	public static int[][] copy(int[][] old) {
		int[][] current = new int[old.length][old[0].length];
		for (int i = 0; i < old.length; i++) {
			for (int j = 0; j < old[i].length; j++) {
				current[i][j] = old[i][j];
			}
		}
		return current;
	}

	public static boolean valid(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] grid = { { 3, 2, 4 }, { 1 ,5, 0 } };
		System.out.println(slidingPuzzle(grid));

	}

}

class PuzzleNode {
	int[][] grid;
	String boardString;
	int i;
	int j;

	public PuzzleNode(int[][] grid, int i, int j) {
		this.grid = grid;
		this.boardString = Arrays.deepToString(grid);
		this.i = i;
		this.j = j;
	}

}
