package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

	public static int totalFruit(int[] tree) {

		if (tree == null || tree.length == 0) {
			return 0;
		}

		if (tree.length == 1) {
			return 1;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		int result = 0;

		while (j < tree.length) {
			int num = tree[j];
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}

			if (map.size() == 2) {
				result = Math.max(result, j - i + 1);
			}

			if (map.size() > 2) {
				int remove = tree[i];
				map.put(remove, map.get(remove) - 1);
				if (map.get(remove) == 0) {
					map.remove(remove);
				}
				i++;
			}
			j++;
		}

		if (map.size() == 1) {
			return tree.length;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
		System.out.println(totalFruit(tree));

	}

}
