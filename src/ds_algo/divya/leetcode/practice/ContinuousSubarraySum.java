package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	/**
	 * Self implemented solution based on prefix sum.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return false;
		}

		int[] sum = new int[nums.length];
		sum[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
			if (sum[i] != 0 && k != 0 && sum[i] % k == 0) {
				return true;
			} else if (k == 0 && sum[i] == 0) {
				return true;
			}
		}

		if (sum[sum.length - 1] == 0) {
			return true;
		}

		for (int i = 2; i < sum.length; i++) {
			for (int j = 0; j <= i - 2; j++) {
				int diff = sum[i] - sum[j];
				if (k != 0 && diff % k == 0) {
					return true;
				} else if (k == 0 && diff == 0) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Leetcode solution. It makes clever use of Modulus math.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySum_leetcode(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (k != 0) {
				sum = sum % k;
			}
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1) {
					return true;
				}
			} else {
				map.put(sum, i);
			}
		}
		return false;

	}

	public static void main(String[] args) {
		int[] nums = { 0 };
		int k = 0;
		System.out.println(checkSubarraySum(nums, k));
	}

}
