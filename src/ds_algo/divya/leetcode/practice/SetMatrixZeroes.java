package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {
	
	/**
	 * Self implemented code.
	 * @param matrix
	 */
	public static void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		List<Zeros> list = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				 if(matrix[i][j]==0) {
					Zeros temp = new Zeros(i, j);
					list.add(temp);
				 }
			}
		}
		List<Zeros> toChange = new ArrayList<>();
		for(Zeros  z : list) {
			setZero(z, matrix,toChange);
		}
		for(Zeros z : toChange) {
			matrix[z.i][z.j]=0;
		}
		System.out.println("end");
	}

	private static void setZero(Zeros z, int[][] matrix, List<Zeros> toChange) {
		int i = z.i;
		int j = z.j;
		// go up
		while (i >= 0) {
			if (matrix[i][j] != 0) {
				Zeros temp = new Zeros(i, j);
				toChange.add(temp);
			}
			i--;
		}
		i = z.i;
		j = z.j;

		// go down
		while (i < matrix.length) {
			if (matrix[i][j] != 0) {
				Zeros temp = new Zeros(i, j);
				toChange.add(temp);
			}
			i++;
		}
		i = z.i;
		j = z.j;

		// go right
		while (j < matrix[0].length) {
			if (matrix[i][j] != 0) {
				Zeros temp = new Zeros(i, j);
				toChange.add(temp);
			}
			j++;
		}
		i = z.i;
		j = z.j;

		// go left
		while (j >= 0) {
			if (matrix[i][j] != 0) {
				Zeros temp = new Zeros(i, j);
				toChange.add(temp);
			}
			j--;
		}
	}
	
	/**
	 * Leetcode solution
	 * @param matrix
	 */
	public static void setZeroes_leetcode(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(rows.contains(i)||rows.contains(j)) {
					matrix[i][j]=0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { 
							{ 0, 1, 2, 0}, 
							{ 3, 4, 5, 2}, 
							{ 1, 3, 1, 5 } 
		};
		setZeroes(matrix);
	}
}

class Zeros{
	int i ;
	int j;
	
	public Zeros(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
	public String toString() {
		return i+" "+j;
	}
}
