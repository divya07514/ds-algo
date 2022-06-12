package ds_algo.divya.leetcode.practice;

public class CountSquareSubmatricesWithAllOnes {

	public static int countSquares(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int r = matrix.length;
		int c = matrix[0].length;

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (matrix[i - 1][j] != 0 && matrix[i][j - 1] != 0) {
					matrix[i][j] = matrix[i][j]+matrix[i - 1][j] + matrix[i][j - 1];
				}

			}
		}

		return matrix[r - 1][c - 1];

	}

	public static void main(String[] args) {
		int[][] matrix = { 
							{ 1,0,1}, 
							{ 1, 1,0 }, 
							{ 1, 1, 0 }
						};
		System.out.println(countSquares(matrix));
	}

}
