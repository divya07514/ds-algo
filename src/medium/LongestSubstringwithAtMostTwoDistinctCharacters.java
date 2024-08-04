package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		Map<Character, Integer> map = new HashMap();
		int max = Integer.MIN_VALUE;

		while (right < n) {
			char c = s.charAt(right);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
			if (map.size() > 2) {
				max = Math.max(max, right - left);
				while (map.size() > 2) {
					char lc = s.charAt(left);
					map.put(lc, map.get(lc) - 1);
					if (map.get(lc) == 0) {
						map.remove(lc);
					}
					left++;
				}
			}
			right++;
		}
		max = Math.max(max, right - left);
		return max;
	}

}
