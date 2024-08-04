package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This should never be asked in an interview.
 * @author divya.thakur
 *
 */
public class WordPatterns2 {

	public static boolean wordPatternMatch(String pattern, String s) {
		List<String> list = new ArrayList<>();
		return backtrack(pattern, s, list, 0);
	}

	private static boolean backtrack(String pattern, String s, List<String> list, int idx) {
		if (list.size() == pattern.length() && idx == s.length()) {
			return wordPattern(pattern, list);
		}
		for (int i = idx + 1; i <= s.length(); i++) {
			String word = s.substring(idx, i);
			list.add(word);
			if (backtrack(pattern, s, list, i)) {
				return true;
			}

			list.remove(list.size() - 1);
		}

		return false;
	}

	public static boolean wordPattern(String p, List<String> list) {
		Map<Character, String> chars = new HashMap();
		Map<String, Character> strings = new HashMap();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			String s = list.get(i);
			if (!chars.containsKey(c)) {
				if (strings.containsKey(s)) {
					return false;
				} else {
					chars.put(c, s);
					strings.put(s, c);
				}
			} else {
				String st = chars.get(c);
				if (!s.equals(st)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "abab";
		String s = "redblueredblue";
		System.out.println(wordPatternMatch(pattern, s));
	}

}
