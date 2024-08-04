package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * simple sliding window problem
 * @author divya.thakur
 *
 */
public class MaximumNumberofVowelsinaSubstringofGivenLength {
	
	public int maxVowels(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');

		int max = Integer.MIN_VALUE;
		int current = 0;
		int left = 0;
		int right = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			if (set.contains(c)) {
				current++;
			}
			if (right - left + 1 == k) {
				max = Math.max(max, current);
				char lc = s.charAt(left);
				if (set.contains(lc)) {
					current = current - 1;
				}
				left++;
			}
			right++;
		}

		return max;
	}
}
