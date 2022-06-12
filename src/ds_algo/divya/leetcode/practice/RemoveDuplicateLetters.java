package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters {

	public static String removeDuplicateLetters(String s) {
		if (s.isEmpty()) {
			return s;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		int left = 0;
		int right = getSmallestIndex(map);
		StringBuilder sb = new StringBuilder();
		while (!map.isEmpty()) {
			char current = '~';
			int index = 0;
			for (int i = left; i <= right; i++) {
				char ch = s.charAt(i);
				if (ch < current && map.containsKey(ch)) {
					current = ch;
					index = i;
				}
			}
			sb.append(current);
			map.remove(current);
			left = index + 1;
			right = getSmallestIndex(map);
		}
		return sb.toString();
	}

	public static int getSmallestIndex(Map<Character, Integer> map) {
		int index = Integer.MAX_VALUE;
		for (int i : map.values()) {
			index = Math.min(index, i);
		}
		return index;
	}

	public static void main(String[] args) {
		String s = "cdadabcc";
		System.out.println(removeDuplicateLetters(s));
	}

}
