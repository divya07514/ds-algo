package medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodWaysToSplitAString {

	public static int numSplits(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> left = new HashMap();
		Map<Character, Integer> right = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!left.containsKey(c)) {
				left.put(c, 1);
			} else {
				left.put(c, left.get(c) + 1);
			}
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			left.put(c, left.get(c) - 1);
			if (left.get(c) == 0) {
				left.remove(c);
			}
			if (!right.containsKey(c)) {
				right.put(c, 1);
			} else {
				right.put(c, right.get(c) + 1);
			}
			if (left.size() == right.size()) {
				count++;
			}
		}

		return count;

	}

	public static void main(String[] args) {
		String s = "aacaba";
		System.out.println(numSplits(s));

	}

}
