package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofOccurrencesofaSubstring {

	public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

		Map<String, Integer> map = new HashMap();
		Map<Character, Integer> freq = new HashMap();

		int left = 0;
		int right = 0;
		int n = s.length();
		int current = 0;
		while (left < n && right < n) {
			char c = s.charAt(right);
			if (!freq.containsKey(c)) {
				freq.put(c, 1);
				current++;
			} else if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) + 1);
				current++;
			}
			if (freq.size() <= maxLetters) {
				if (minSize <= current && current <= maxSize) {
					String key = s.substring(left, right + 1);
					if (!map.containsKey(key)) {
						map.put(key, 1);
					} else {
						map.put(key, map.get(key) + 1);
					}
					char lc = s.charAt(left);
					freq.put(lc, freq.get(lc) - 1);
					if (freq.get(lc) == 0) {
						freq.remove(lc);
					}
					current--;
					left++;
				}
			}
			if (freq.size() > maxLetters) {
				char lc = s.charAt(left);
				freq.put(lc, freq.get(lc) - 1);
				if (freq.get(lc) == 0) {
					freq.remove(lc);
				}
				current--;
				left++;
			}
			right++;
		}
		String str = s.substring(left, right);
		if (minSize <= str.length() && str.length() <= maxSize) {
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}
		int result = 0;
		for (String c : map.keySet()) {
			result = Math.max(result, map.get(c));
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "aababcaab";
		int maxLetters = 2;
		int minSize = 3;
		int maxSize = 4;
		System.out.println(maxFreq(s, maxLetters, minSize, maxSize));
	}

}
