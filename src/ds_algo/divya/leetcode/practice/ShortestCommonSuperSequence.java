package ds_algo.divya.leetcode.practice;

public class ShortestCommonSuperSequence {

	public static String shortestCommonSupersequence(String str1, String str2) {
		int r = str1.length();
		int c = str2.length();
		int[][] dp = new int[r + 1][c + 1];
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int left = dp[i - 1][j];
					int right = dp[i][j - 1];
					dp[i][j] = Math.max(left, right);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = r;
		int j = c;
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				sb.append(str1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					sb.append(str1.charAt(i - 1));
					i--;
				} else {
					sb.append(str2.charAt(j - 1));
					j--;
				}
			}
		}
		while (i > 0) {
			sb.append(str1.charAt(i - 1));
			i--;
		}
		while (j > 0) {
			sb.append(str2.charAt(j - 1));
			j--;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String str1 = "abac", str2 = "cab";
		System.out.println(shortestCommonSupersequence(str1, str2));

	}

}
