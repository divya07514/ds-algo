package ds_algo.divya.leetcode.practice;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

	public static int findKthLargest(int[] array, int k) {
		int i = 0;
		int j = array.length;
		int smallest = j - k;
		int index = quickSelect(array, smallest, i, j);
		return array[index];
	}

	private static int quickSelect(int[] array, int smallest, int i, int j) {
		int index = partition(array, i, j);
		if (index == smallest) {
			return index;
		}
		if (index > smallest) {
			return quickSelect(array, smallest, i, index);
		} else {
			return quickSelect(array, smallest, index + 1, j);
		}
	}

	private static int partition(int[] array, int i, int j) {
		if (i < array.length) {
			int pivot = array[i];
			int low = i;
			while (i < j) {
				do {
					i++;
				} while (i < array.length && array[i] <= pivot);

				do {
					j--;
				} while (j > 0 && array[j] > pivot);

				if (i < j) {
					swap(array, i, j);
				}
			}
			swap(array, j, low);
		}
		return j;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int findKthLargest_minHeap(int[] array, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		int i = 0;
		for (; i < k; i++) {
			q.add(array[i]);
		}
		for(;i<array.length;i++) {
			if(array[i]>q.peek()) {
				q.poll();
				q.add(array[i]);
			}
		}
		return q.peek();
	}

	public static void main(String[] args) {
		int[] array = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 2;
		System.out.println(findKthLargest(array, k));
		//System.out.println(findKthLargest_minHeap(array, k));
	}

}
