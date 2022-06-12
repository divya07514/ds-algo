package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class SubArrayDivisibleByX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] nums = new int[n];
			int index = 0;
			for (int j = 0; j < n; j++) {
				nums[index++] = sc.nextInt();
			}
			int length = maxLength(x, nums);
			System.out.println(length);
		}

	}

	private static int maxLength(int x, int[] nums) {
		int left = -1;
		int right = -1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (nums[i] % x != 0) {
				if (left == -1) {
					left = i;
				}
				right = i;
			}
		}
		int result = nums.length - Math.min(left + 1, nums.length - right);
		if (sum % x != 0) {
			result = nums.length;
		} else if (left == -1) {
			result = -1;
		}
		return result;
	}

}
