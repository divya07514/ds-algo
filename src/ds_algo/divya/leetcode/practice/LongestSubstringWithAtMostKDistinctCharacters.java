package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {

		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int right = 0;
		int max = 0;

		while (right < s.length()) {
			char ch = s.charAt(right++);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}

			if (map.size() <= k) {
				max = Math.max(max, right - left);
			} else if (map.size() > k) {
				while (map.size() > k) {
					char c = s.charAt(left++);
					map.put(c, map.get(c) - 1);
					if (map.get(c) == 0) {
						map.remove(c);
					}
				}
			}

		}

		return max;
	}

	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
	}

}
