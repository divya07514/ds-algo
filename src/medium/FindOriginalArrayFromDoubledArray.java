package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Zero and its counts are the edge cases for this question
 * 
 * @author divya.thakur
 *
 */
public class FindOriginalArrayFromDoubledArray {

	public static void main(String[] args) {
		int[] input = { 2, 1, 2, 4, 2, 4 };
		int[] result = findOriginalArray(input);
		for (int i : result) {
			System.out.print(i + " ");
		}

	}

	public static int[] findOriginalArray(int[] changed) {
		if (changed == null || changed.length == 0) {
			return new int[0];
		}
		int n = changed.length;
		if (n % 2 != 0) {
			return new int[0];
		}
		int[] result = new int[n / 2];
		Arrays.sort(changed);
		Map<Integer, Integer> map = new HashMap();
		for (int i : changed) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		int index = 0;
		for (int i : changed) {
			if (map.get(i) > 0) {
				map.put(i, map.get(i) - 1);
				int mul = i * 2;
				if (map.containsKey(mul) && map.get(mul) > 0) {
					map.put(mul, map.get(mul) - 1);
					result[index++] = i;
				} else {
					return new int[0];
				}
			}
		}

		return result;
	}

}
