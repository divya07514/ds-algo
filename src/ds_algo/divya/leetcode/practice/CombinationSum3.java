package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		int currentSum = 0;
		int index = 1;
		sum(result, list, currentSum, index, k, n);

		return result;
	}

	private static void sum(List<List<Integer>> result, List<Integer> list, int currentSum, int index, int k, int n) {
		if (index > 9) {
			return;
		}
		if (list.size() == k) {
			if (currentSum == n) {
				List<Integer> temp = new ArrayList<Integer>(list);
				result.add(temp);
				return;
			} else {
				return;
			}
		}
		currentSum = currentSum + index;
		list.add(index);
		sum(result, list, currentSum, index + 1, k, n);
		int i = list.remove(list.size() - 1);
		currentSum = currentSum - i;
		sum(result, list, currentSum, index + 1, k, n);

	}

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		System.out.println(combinationSum3(k, n));

	}

}
