package com.divya.union.find;

import java.util.Scanner;

public class Fence {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			nums[idx++] = sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + nums[i];
		}

		int min = sum;
		int index = 0;
		int ans = 1;
		for (int i = k; i < n; i++) {
			sum = sum - nums[index++];
			sum = sum + nums[i];
			if (sum < min) {
				min = sum;
				ans = index+1;
			}

		}
		System.out.println(ans);
	}

}
