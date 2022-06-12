package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class PrisonTransfer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int c = sc.nextInt();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		int count = 0;
		int left = 0;
		int right = 0;

		while (right < n) {
			if (nums[right] <= t) {
				if (right - left + 1 == c) {
					count++;
					left++;
				}
				right++;
			} else {
				right = right + 1;
				left = right;
			}

		}

		System.out.println(count);
	}

}
