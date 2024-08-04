package medium;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

	public static int partitionArray(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return 1;
		}

		Arrays.sort(nums);

		int count = 0;
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int n = nums[i];
			max = Math.max(n, max);
			min = Math.min(n, min);
			if (max - min > k) {
				count++;
				max = n;
				min = n;
			}
			if (i == nums.length - 1 && max - min <= k) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 6, 1, 2, 5 };
		int k = 2;
		System.out.println(partitionArray(nums, k));
	}

}
