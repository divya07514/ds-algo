package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromicSubstring {

	static String longest = "";

	/**
	 * Self implemented solution.
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome_tle(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		count(s);
		String result = longest;
		longest = "";
		return result;
	}

	private static void count(String s) {
		int left = 0;
		int right = 1;
		Set<String> set = new HashSet<>();
		while (left < s.length()) {
			if (right > s.length()) {
				left++;
				right = left + 1;
				continue;
			}
			String temp = s.substring(left, right);
			checkPalindrome(temp, set);
			right++;
		}

	}

	public static void checkPalindrome(String s, Set<String> set) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return;
			}
			if (left + 1 < right) {
				String inner = s.substring(left + 1, right);
				if (set.contains(inner)) {
					if (s.length() > longest.length()) {
						longest = s;
					}
					set.add(s);
					return;
				}
			}
			left++;
			right--;
		}
		if (s.length() > longest.length()) {
			longest = s;
		}
		set.add(s);
	}

	public static String longestPalindrome(String s) {
		if (s.length() == 1) {
			return s;
		}
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		String result = "";
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				dp[i][j] = s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[i - 1][j + 1]);
				if (dp[i][j]) {
					if (result.length() < i - j + 1) {
						result = s.substring(j, i + 1);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "aba";
		System.out.println(longestPalindrome_tle(s));
		System.out.println(longestPalindrome(s));
	}

}
