package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRepeatingSubstring {

	/**
	 * Self implemented code. However, its time complexity is not good. Based on
	 * Longest Common Prefix approach. Suffix Array is used.
	 * 
	 * @param s
	 * @return
	 */
	public static int longestRepeatingSubstring_self(String s) {

		if (s.length() == 1) {
			return 0;
		}
		List<String> list = new ArrayList<>();
		int index = s.length() - 1;
		for (; index >= 0; index--) {
			String sub = s.substring(index);
			list.add(sub);
		}
		Collections.sort(list);
		int result = 0;

		for (int i = 1; i < list.size(); i++) {
			String current = list.get(i);
			String prev = list.get(i - 1);
			String lcp = lcp(current, prev);
			result = Math.max(result, lcp.length());
		}
		return result;
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

	/**
	 * Leetcode solution from discussions
	 * 
	 * @param S
	 * @return
	 */
	public static int longestRepeatingSubstring_leetcode(String s) {
		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				map.put(ch, temp);
			} else {
				map.get(ch).add(i);
			}
		}
		int result = 0;
		for (char c : map.keySet()) {
			if (map.get(c).size() > 1) {
				List<Integer> list = map.get(c);
				for (int i = 0; i < list.size(); i++) {
					for (int j = i + 1; j < list.size(); j++) {
						int first = list.get(i);
						int second = list.get(j);
						int count = 0;
						while(second < s.length() && s.charAt(first++)==s.charAt(second++)) {
							count++;
						}
						result = Math.max(result, count);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "aaabaabbbaaabaabbaabbbabbbaaaabbaaaaaabbbaabbbbbbbbbaaaabbabbaba";
		System.out.println(longestRepeatingSubstring_self(s));
		System.out.println(longestRepeatingSubstring_leetcode(s));
	}

}
