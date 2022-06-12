package ds_algo.divya.leetcode.practice;

public class QuickSort {

	public static void sort(int[] array, int i, int j) {
		if (i < j) {
			int index = partition(array, i, j);
			sort(array, i, index);
			sort(array, index + 1, j);
		}

	}

	private static int partition(int[] array, int i, int j) {
		int pivot = array[i];
		int low = i;
		while (i < j) {
			do {
				i++;
			} while (i < array.length && array[i] <= pivot);

			do {
				j--;
			} while (j >= 0 && array[j] > pivot);

			if (i < j) {
				ArrayUtil.swap(array, i, j);
			}
		}
		ArrayUtil.swap(array, low, j);
		return j;
	}

	public static void main(String[] args) {
		int[] array = ArrayUtil.arrayOfSize(7);
		ArrayUtil.printArray(array);
		int i = 0;
		int j = array.length;
		sort(array, i, j);
		System.out.println();
		ArrayUtil.printArray(array);
	}

}
