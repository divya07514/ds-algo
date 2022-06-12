package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

	public static String minWindow(String s, String t) {
		if (s == null || t == null) {
			return "";
		}
		if (s.length() < t.length()) {
			return "";
		}
		int left = 0;
		int start = 0;
		Map<Character, Integer> text = new HashMap<Character, Integer>();
		Map<Character, Integer> pat = new HashMap<Character, Integer>();
		String minString = s + s;
		initPatMap(t, pat);
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if (pat.containsKey(ch)) {
				if (!text.containsKey(ch)) {
					text.put(ch, 1);
				} else {
					text.put(ch, text.get(ch) + 1);
				}
			}
			if (mapEquals(pat, text)) {
				while (mapEquals(pat, text)) {
					char temp = s.charAt(left);
					if (text.containsKey(temp)) {
						text.put(temp, text.get(temp) - 1);
						if (text.get(temp) == 0) {
							text.remove(temp);
						}
					}
					left++;
				}
				start = left;
				String sub = s.substring(--start, right + 1);
				if (sub.length() < minString.length()) {
					minString = sub;
				}
			}
		}
		if (minString.equals(s + s)) {
			return "";
		} else {
			return minString;
		}
	}

	private static boolean mapEquals(Map<Character, Integer> pat, Map<Character, Integer> text) {
		for (char ch : pat.keySet()) {
			if (!text.containsKey(ch)) {
				return false;
			}
			if (text.get(ch) < pat.get(ch)) {
				return false;
			}
		}
		return true;
	}

	private static void initPatMap(String t, Map<Character, Integer> pat) {
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (!pat.containsKey(ch)) {
				pat.put(ch, 1);
			} else {
				pat.put(ch, pat.get(ch) + 1);
			}
		}
	}

	public static void main(String[] args) {
		String s = "this is a test string”";
		String t = "tist";
		System.out.println(minWindow(s, t));
	}

}
