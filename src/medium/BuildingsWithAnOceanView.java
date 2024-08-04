package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildingsWithAnOceanView {

	public int[] findBuildings(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		List<Integer> list = new ArrayList();
		int n = nums.length;
		list.add(n - 1);
		int max = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] > max) {
				list.add(i);
				max = nums[i];
			}
		}

		int[] result = new int[list.size()];
		int index = 0;
		for (int i : list) {
			result[index++] = i;
		}

		Arrays.sort(result);

		return result;
	}
}
