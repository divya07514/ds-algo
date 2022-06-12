package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumFallingPathSum {

	public static int minFallingPathSum(int[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length) {
			return 0;
		}
		int minSum = Integer.MAX_VALUE;
		Map<MPair, Integer> map = new HashMap<MPair, Integer>();
		
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				MPair temp = new MPair(i, j);
				int left = getVal(matrix, map, i + 1, j - 1);
				int down = getVal(matrix, map, i + 1, j);
				int right = getVal(matrix, map, i + 1, j + 1);
				int min = Math.min(left, Math.min(down, right));
				if (min == Integer.MAX_VALUE) {
					map.put(temp, matrix[i][j]);
				}else {
					map.put(temp, matrix[i][j] + min);
				}
			}
		}
		
		for(int j=0;j<matrix[0].length;j++) {
			int temp = map.get(new MPair(0, j));
			minSum = Math.min(temp, minSum);
		}
		
		return minSum;
	}

	private static int getVal(int[][] matrix, Map<MPair, Integer> map, int i, int j) {
		int val;
		if(!map.containsKey(new MPair(i, j))) {
			 val = isValid(i, j, matrix);
		}else {
			val = map.get(new MPair(i, j));
		}
		return val;
	}


	private static int isValid(int i, int j, int[][] matrix) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
			return matrix[i][j];
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { 	{ 1, 2, 3 },
							{ 4, 5, 6 },
							{ 7, 8, 9 } };

		System.out.println(minFallingPathSum(matrix));
	}
}

class MPair {
	int x;
	int y;

	public MPair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MPair other = (MPair) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
