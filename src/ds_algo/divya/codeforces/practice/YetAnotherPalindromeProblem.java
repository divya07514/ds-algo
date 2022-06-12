package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class YetAnotherPalindromeProblem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int length = palindrome(nums);
			if(length>=3) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}

	}

	private static int palindrome(int[] nums) {
		int[] reverse = new int[nums.length];
		int index = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			reverse[index++] = nums[i];
		}
		int n = nums.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
					if(i==0 || j==0) {
						dp[i][j] = 0;
					}else if(nums[i-1]==reverse[j-1]) {
						dp[i][j]= 1 + dp[i-1][j-1];
					}else {
						int left = dp[i-1][j];
						int right = dp[i][j-1];
						dp[i][j] = Math.max(left, right);
					}
			}
		}

		return dp[n][n];
	}

}
