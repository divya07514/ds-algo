package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class LongestDuplicateSubstring {

	public static String longestDupSubstring(String s) {
		if(s==null || s.length()==0) {
			return "";
		}
		int length = s.length();
		String[] suffix = new String[length];
		for (int i = 0; i < length; i++) {
			suffix[i] = s.substring(i, length);
		}
		Arrays.sort(suffix);
		String lds = "";
		for (int i = 1; i < length; i++) {
			String lcp = lcp(suffix[i - 1], suffix[i]);
			if (lcp.length() > lds.length()) {
				lds = lcp;
			}

		}
		return lds;
	}

	private static String lcp(String one, String two) {
		String lcp = "";
		String shortest = "";
		if (one.length() < two.length()) {
			shortest = one;
		} else {
			shortest = two;
		}
		for (int i = 0; i <= shortest.length(); i++) {
			String sub = one.substring(0, i);
			if (!two.startsWith(sub)) {
				break;
			} else {
				if (sub.length() > lcp.length()) {
					lcp = sub;
				}
			}
		}
		return lcp;
	}

	public static void main(String[] args) {
		String s = "aaabaabbbaaabaabbaabbbabbbaaaabbaaaaaabbbaabbbbbbbbbaaaabbabbaba";
		System.out.println(longestDupSubstring(s));
	}

}
