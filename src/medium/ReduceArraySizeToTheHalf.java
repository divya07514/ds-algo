package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReduceArraySizeToTheHalf {

	public static int minSetSize(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		Integer[] array = new Integer[map.size()];
		int index = 0;
		for (int i : map.keySet()) {
			array[index++] = map.get(i);
		}
		if (array.length == 1) {
			return 1;
		}
		Arrays.sort(array, Collections.reverseOrder());
		int n = nums.length;
		int result = 0;
		int count = 0;
		int half = n / 2;
		int left = n;
		for (int i : array) {
			// System.out.println(left + ", "+ i + ", "+ half);
			left = left - i;
			result++;
			if (left <= half) {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {3,3,3,3,5,5,5,2,2,7};
		System.out.println(minSetSize(arr));

	}

}
