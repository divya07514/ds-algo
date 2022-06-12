package ds_algo.divya.leetcode.practice;

public class BinarySearch {

	public static int iterative(int[] array, int item) {
		int i = 0;
		int j = array.length - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (array[mid] == item) {
				return mid;
			} else {
				if (item > array[mid]) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			}
		}
		return -1;
	}

	public static int recursive(int[] array, int item) {
		int i = 0;
		int j = array.length - 1;
		return search(array, item, i, j);
	}

	private static int search(int[] array, int item, int i, int j) {
		int mid = (i + j) / 2;
		if (i > j) {
			return -1;
		}
		if (array[mid] == item) {
			return mid;
		} else {
			if (item > array[mid]) {
				return search(array, item, mid + 1, j);
			} else {
				return search(array, item, i, mid - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int item = 7;
		System.out.println(iterative(array, item));
		System.out.println(recursive(array, item));
	}

}
