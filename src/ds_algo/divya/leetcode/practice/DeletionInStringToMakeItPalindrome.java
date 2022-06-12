package ds_algo.divya.leetcode.practice;

/**
 * Minimum number of deletion in a string to make it a palindrome
 * 
 * @param args
 */

public class DeletionInStringToMakeItPalindrome {

	public static int deletions(String a) {
		StringBuilder sb = new StringBuilder(a);
		sb.reverse();
		String b = sb.toString();

		int r = a.length();
		int c = b.length();
		int[][] dp = new int[r + 1][c + 1];

		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int left = dp[i - 1][j];
					int right = dp[i][j - 1];
					dp[i][j] = Math.max(left, right);
				}
			}
		}

		int lcsLength = dp[r][c];

		return a.length() - lcsLength;
	}

	public static void main(String[] args) {
		String a = "aebcbda";
		System.out.println(deletions(a));
	}

}
