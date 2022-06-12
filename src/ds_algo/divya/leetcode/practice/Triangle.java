package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {

	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int len = triangle.size() - 2;
		for (int i = len; i >= 0; i--) {
			List<Integer> current = triangle.get(i);
			List<Integer> below = triangle.get(i + 1);
			int[] minArray = new int[current.size()];
			for (int j = 0; j < current.size(); j++) {
				int down = Integer.MAX_VALUE;
				int right = Integer.MAX_VALUE;
				int currentVal = current.get(j);
				if (j + 1 < below.size()) {
					right = currentVal + below.get(j + 1);
				}
				down = currentVal + below.get(j);
				int min = Math.min(right, down);
				minArray[j] = min;
			}
			current.clear();
			for (int j = 0; j < minArray.length; j++) {
				current.add(minArray[j]);
			}
		}
		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		triangle.add(list1);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		triangle.add(list2);

		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		triangle.add(list3);

		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list4);

		System.out.println(minimumTotal(triangle));
	}

}
