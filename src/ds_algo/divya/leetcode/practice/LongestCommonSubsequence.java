package ds_algo.divya.leetcode.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestCommonSubsequence {

	public static int longestCommonSubsequence_recursive(String text1, String text2) {
		int n = text1.length() - 1;
		int m = text2.length() - 1;
		return lcs_recursive(text1, text2, n, m);
	}

	private static int lcs_recursive(String text1, String text2, int n, int m) {
		if (n < 0 || m < 0) {
			return 0;
		}
		if (text1.charAt(n) == text2.charAt(m)) {
			return 1 + lcs_recursive(text1, text2, n - 1, m - 1);
		} else {
			return Math.max(lcs_recursive(text1, text2, n - 1, m), lcs_recursive(text1, text2, n, m - 1));
		}
	}

	public static int longestCommonSubsequence_memo(String text1, String text2) {
		if (text1 == null || text2 == null) {
			return 0;
		}
		int n = text1.length();
		int m = text2.length();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		int res = lcs_memo(text1, text2, n, m, map);
		return res;
	}

	private static int lcs_memo(String text1, String text2, int n, int m, Map<String, Integer> map) {
		if (n == 0 || m == 0) {
			return 0;
		}
		String key = text1.substring(0, n) + ";" + text2.substring(0, m);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
			map.put(key, 1 + lcs_memo(text1, text2, n - 1, m - 1, map));
			return map.get(key);
		} else {
			int t1 = lcs_memo(text1, text2, n - 1, m, map);
			int t2 = lcs_memo(text1, text2, n, m - 1, map);
			map.put(key, Math.max(t1, t2));
			return map.get(key);
		}
	}

	public static int longestCommonSubsequence_tabulation(String text1, String text2) {
		int r = text1.length();
		int c = text2.length();
		int[][] dp = new int[r + 1][c + 1];
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
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

	public static String longestCommonSubsequence_print(String text1, String text2) {
		int r = text1.length();
		int c = text2.length();
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[r + 1][c + 1];
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
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
			if (text1.charAt(i-1) == text2.charAt(j-1)) {
				sb.append(text1.charAt(i-1));
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

		return sb.reverse().toString();

	}

	public static void main(String[] args) {
		String text1 = "hofubmnylkra";
		String text2 = "pqhgxgdofcvmr";
		System.out.println(longestCommonSubsequence_recursive(text1, text2));
		System.out.println(longestCommonSubsequence_memo(text1, text2));
		System.out.println(longestCommonSubsequence_tabulation(text1, text2));
		System.out.println(longestCommonSubsequence_print(text1, text2));
	}
	/*
	 * "hofubmnylkra" "pqhgxgdofcvmr"
	 */

}
