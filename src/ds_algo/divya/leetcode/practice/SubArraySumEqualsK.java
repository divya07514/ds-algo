package ds_algo.divya.leetcode.practice;

import java.util.HashMap;

public class SubArraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= nums.length; j++) {
				if (sum[j] - sum[i] == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static int subarraySum_leetcode(int[] nums, int k) {
		int count = 0, currentSum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			currentSum = currentSum + num;
			if (currentSum == k) {
				count++;
			}
			int temp = currentSum - k;
			count = count + map.getOrDefault(temp, 0);
			map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 4, 20, 3, 10, 5 };
		int k = 33;
		System.out.println(subarraySum(nums, k));
		System.out.println(subarraySum_leetcode(nums, k));
	}

}
