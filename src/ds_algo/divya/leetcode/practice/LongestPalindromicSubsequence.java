package ds_algo.divya.leetcode.practice;

public class LongestPalindromicSubsequence {

	public static int longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		StringBuilder sb = new StringBuilder(s);
		String t = sb.reverse().toString();
		return lps(s, t);
	}

	private static int lps(String s, String t) {
		int r = s.length();
		int c = t.length();
		int[][] dp = new int[r + 1][c + 1];
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int left = dp[i - 1][j];
					int right = dp[i][j - 1];
					dp[i][j] = Math.max(left, right);
				}
			}
		}
		return dp[r][c];
	}

	public static String longestPalindrome_print(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder(s);
		String t = sb.reverse().toString();
		return lps_print(s, t);
	}

	private static String lps_print(String s, String t) {
		StringBuilder sb = new StringBuilder();
		int r = s.length();
		int c = t.length();
		int[][] dp = new int[r + 1][c + 1];
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int left = dp[i - 1][j];
					int right = dp[i][j - 1];
					dp[i][j] = Math.max(left, right);
				}
			}
		}
		int i = r;
		int j = c;
		while (i > 0 && j > 0) {
			if (s.charAt(i - 1) == t.charAt(j - 1)) {
				sb.append(s.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "agbcba";
		System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome_print(s));

	}

}
