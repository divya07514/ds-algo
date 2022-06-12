package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithAtLeastKDistinctCharacters {

	/**
	 * TLE Solution. Generating every substring and simultaneously checking for
	 * unique counts.
	 * 
	 * @param k
	 * @return
	 */
	public static long kDistinctCharacters_tle(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		long result = 0L;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int[] array = new int[26];
			long count = 0L;
			for (int j = i; j < n; j++) {
				char ch = s.charAt(j);
				if (array[ch - 'a'] == 0) {
					count++;
				}
				array[ch - 'a']++;
				if (count >= k) {
					result++;
				}
			}
		}
		return result;
	}

	/**
	 * Sliding window approach. IF a string of length i contains  k unique chars
	 * then any string of length i +j will also contain k unique characters.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public static long kDistinctCharacters(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int begin = 0, end = 0;
		long ans = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			end++;
			while (map.size() >= k) {
				char pre = s.charAt(begin);
				if (map.containsKey(pre)) {
					map.put(pre, map.getOrDefault(pre, 0) - 1);
					if (map.get(pre) == 0) {
						map.remove(pre);
					}
				}
				ans = ans + s.length() - end + 1;
				begin++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		String s = "bkacsrgjkynenkwbfaeblmbjfjshojryawvsuftmqftkjqnsjfhvbsddwiwmifhphftkckkedzotkbiplqjsgdyqgjnclwjqxbbc";
		int k = 2;
		System.out.println(kDistinctCharacters_tle(s, k));
		System.out.println(kDistinctCharacters(s, k));

	}

}
