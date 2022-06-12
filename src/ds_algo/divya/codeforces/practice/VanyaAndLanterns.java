package ds_algo.divya.codeforces.practice;

import java.util.Arrays;
import java.util.Scanner;

public class VanyaAndLanterns {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] nums = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			nums[index++] = sc.nextInt();
		}
		Arrays.sort(nums);
		double max = 0.0d;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, nums[i] - nums[i - 1]);
		}
		double half = 1.0d*(max/2.0);
		int left = nums[0] - 0;
		int right = l - nums[n-1];
		double result = Math.max(half, Math.max(left, right));
		System.out.println(result);

	}

}
