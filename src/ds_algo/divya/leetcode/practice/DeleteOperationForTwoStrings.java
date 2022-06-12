package ds_algo.divya.leetcode.practice;

/**
 * Minimum number of deletions and insertions to transform one string into another (same question )
 * 
 * Application of LCS
 * 
 * @author abc
 *
 */
public class DeleteOperationForTwoStrings {

	public static int minDistance(String a, String b) {
		if (a == null || b == null ) {
			return 0;
		}
		if (a.isEmpty() && !b.isEmpty() ) {
			return b.length();
		}
		if (!a.isEmpty() && b.isEmpty() ) {
			return a.length();
		}
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
		int result = (a.length() - lcsLength) + (b.length() - lcsLength);
		return result;
	}

	public static void main(String[] args) {
		String a = "";
		String b = "p";
		System.out.println(minDistance(a, b));

	}

}
