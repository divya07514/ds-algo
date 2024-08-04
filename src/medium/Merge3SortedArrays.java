package medium;

import java.util.ArrayList;
import java.util.List;

public class Merge3SortedArrays {

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 6, 8, 9 };
		int[] b = { 1, 2, 3, 5, 6, 7, 9, 13, 14, 14, 15, 15 };
		int[] c = { 4, 6, 7, 8, 10, 11, 11, 11, 11, 12 };

		List<Integer> sorted = sort(a, b, c);

		for (int i : sorted) {
			System.out.print(i + " ");
		}

	}

	private static List<Integer> sort(int[] a, int[] b, int[] c) {
		List<Integer> result = new ArrayList();

		int i = 0, j = 0, k = 0;

		while (i < a.length || j < b.length || k < c.length) {

			int A = i < a.length ? a[i] : Integer.MAX_VALUE;
			int B = j < b.length ? b[j] : Integer.MAX_VALUE;
			int C = k < c.length ? c[k] : Integer.MAX_VALUE;

			int min = Math.min(A, Math.min(B, C));

			if (min == A) {
				i++;
			} else if (min == B) {
				j++;
			} else {
				k++;
			}
			if (result.isEmpty()) {
				result.add(min);
			}
			if (result.get(result.size() - 1) != min) {
				result.add(min);
			}
		}

		return result;
	}

}
