package ds_algo.divya.codeforces.practice;

import java.util.Arrays;
import java.util.Scanner;

public class LessOrEqual {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] nums = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			nums[index++] = sc.nextInt();
		}
		Arrays.sort(nums);
		int result = 0;

		if (k == 0) {
			result = nums[0] - 1;
			if(result>=1) {
				System.out.println(result);
				return;
			}
		} else {
			result = nums[k - 1];
		}

		int count = 0;
		index = 0;

		while (index < n && nums[index++] <= result) {
			count++;
		}

		if (count != k || !(1 <= result)) {
			result = -1;
		}

		System.out.println(result);

	}

}
