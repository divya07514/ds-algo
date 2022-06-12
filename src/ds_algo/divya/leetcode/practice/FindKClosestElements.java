package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> list = new ArrayList<>();
		for (int i : arr) {
			list.add(i);
		}

		Collections.sort(list, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));

		System.out.println(list);
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			result.add(list.get(i));
		}
		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;
		System.out.println(findClosestElements(arr, k, x));

	}

}
