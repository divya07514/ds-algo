package ds_algo.divya.leetcode.practice;

public class Searcha2DMatrix2 {
	
	/**
	 * Self implemented code.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix_binary_search(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			boolean result = search(matrix[i], target);
			if (result) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean search(int[] array, int target) {
		int i = 0;
		int j = array.length-1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (array[mid] == target) {
				return true;
			} else {
				if (target > array[mid]) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			}
		}
		return false;
	}
	
	/**
	 * Leetcode solution.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length==0) {
			return false;
		}
		int r = 0;
		int c = matrix[0].length-1;
		
		while(r < matrix.length && c>=0) {
			if(matrix[r][c]==target) {
				return true;
			}
			if(target > matrix[r][c]) {
				r++;
			}else {
				c--;
			}
		}
		return false;
	}



	public static void main(String[] args) {
		int[][] matrix = {
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
				};
		int target = 21;
		System.out.println(searchMatrix(matrix, target));

	}

}
