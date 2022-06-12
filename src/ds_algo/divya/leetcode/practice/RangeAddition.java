package ds_algo.divya.leetcode.practice;

public class RangeAddition {
	
	public int[] getModifiedArray(int length, int[][] updates) {

		int[] result = new int[length];

		for (int i = 0; i < updates.length; i++) {
			int[] temp = updates[i];
			int start = temp[0];
			int end = temp[1];
			int val = temp[2];

			if (start < result.length) {
				result[start] = result[start] + val;
			}
			if (end + 1 < result.length) {
				result[end + 1] = result[end + 1] - val;
			}
		}

		for (int i = 1; i < result.length; i++) {
			result[i] = result[i] + result[i - 1];
		}

		return result;
	}
}
