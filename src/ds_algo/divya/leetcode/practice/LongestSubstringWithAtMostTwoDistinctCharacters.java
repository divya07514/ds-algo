package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();

		while (right < s.length()) {
			char ch = s.charAt(right);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
			if (map.size() < 2) {
				right++;
				continue;
			}
			if (map.size() == 2) {
				max = Math.max(right - left + 1, max);
			} else {
				while (map.size() > 2) {
					char c = s.charAt(left);
					map.put(c, map.get(c) - 1);
					if (map.get(c) == 0) {
						map.remove(c);
					}
					left++;
				}
			}
			right++;
		}

		if (!map.isEmpty() && map.size() == 1) {
			for (Character c : map.keySet()) {
				max = Math.max(max, map.get(c));
			}

		}
		return max;
	}

	public static void main(String[] args) {
		String s ="ccaabbb";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));

	}

}
