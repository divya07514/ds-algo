package ds_algo.divya.codeforces.practice;

import java.util.Arrays;
import java.util.Scanner;

public class MiddleClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int a = 0; a < t; a++) {
			int n = s.nextInt();
			int x = s.nextInt();
			int[] nums = new int[n];
			long sum = 0;
			for (int j = 0; j < n; j++) {
				sum += nums[j] = s.nextInt();
			}
			Arrays.sort(nums);
			int ans = n;
			for (int i = 0; i < n; i++) {
				if ((long) Math.floor(sum / ans) >= x) {
					break;
				}
				ans--;
				sum -= nums[i];
			}
			System.out.println(ans);
		}
	}

}
