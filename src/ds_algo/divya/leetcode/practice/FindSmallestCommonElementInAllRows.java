package ds_algo.divya.leetcode.practice;

public class FindSmallestCommonElementInAllRows {
	
	public int smallestCommonElement(int[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		int[] temp = matrix[0];
		int r = matrix.length;
		int index = 0;
		boolean result = true;
		int val = -1;
		for (int i : temp) {
			while (++index < r) {
				boolean check = search(matrix[index], i);
				result = result && check;
			}
			if (!result) {
				result = true;
			} else {
				val = i;
				break;
			}
			index = 0;
		}
		return !result ? -1 : val;
	}

	public boolean search(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return true;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
