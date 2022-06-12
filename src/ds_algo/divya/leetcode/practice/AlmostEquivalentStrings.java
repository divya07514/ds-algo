package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AlmostEquivalentStrings {

	public static String[] areAlmostEquivalent(String[] s, String[] t) {
		String[] result = new String[s.length];
		for (int i = 0; i < s.length; i++) {
			String s1 = s[i];
			String s2 = t[i];
			String temp = equivalent(s1, s2);
			result[i] = temp;
		}
		return result;
	}

	private static String equivalent(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return "NO";
		}
		Map<Character, Integer> map1 = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if (!map1.containsKey(ch)) {
				map1.put(ch, 1);
			} else {
				map1.put(ch, map1.get(ch) + 1);
			}

		}
		Map<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			if (!map2.containsKey(ch)) {
				map2.put(ch, 1);
			} else {
				map2.put(ch, map2.get(ch) + 1);
			}

		}
		Set<Character> keys = map1.keySet();
		for (Character c : keys) {
			if (Math.abs(map1.get(c) - map2.get(c)) > 3) {
				return "NO";
			}
		}
		return "YES";
	}

	public static void main(String[] args) {
		String[] s = { "aabaab", "aaa" };
		String[] t = { "bbabbc", "aab" };
		String[] res = areAlmostEquivalent(s, t);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
