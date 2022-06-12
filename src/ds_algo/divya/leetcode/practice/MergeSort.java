package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class MergeSort {

	private static int[] mergeSort(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int mid = array.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));
		return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int idx = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				result[idx] = left[i];
				idx++;
				i++;
			} else {
				result[idx] = right[j];
				idx++;
				j++;
			}
		}
		while (i < left.length) {
			result[idx] = left[i];
			idx++;
			i++;
		}
		while (j < right.length) {
			result[idx] = right[j];
			idx++;
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = ArrayUtil.arrayOfSize(10);
		ArrayUtil.printArray(array);
		int[] result = mergeSort(array);
		System.out.println();
		ArrayUtil.printArray(result);

	}

}
