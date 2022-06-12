package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class PetyaAndCountryside {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println(1);
			return;
		}
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int[] right = new int[n];
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] <= nums[j-1]) {
					count++;
				} else {
					break;
				}
			}
			right[i] = count;
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] <= nums[j+1]) {
					count++;
				}else {
					break;
				}
			}
			int current = count + right[i];
			max = Math.max(current, max);
		}
		
		System.out.println(max+1);
	}

}
