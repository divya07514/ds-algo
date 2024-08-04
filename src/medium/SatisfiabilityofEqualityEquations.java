package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SatisfiabilityofEqualityEquations {

	Map<Character, List<Character>> equals;

	public boolean equationsPossible(String[] eq) {
		int n = eq.length;
		if (n == 0) {
			return true;
		}
		equals = getEquals(eq);
		for (String s : eq) {
			char one = s.charAt(0);
			char two = s.charAt(3);
			char ch = s.charAt(1);
			if (ch == '!') {
				if (dfs(one, two)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean dfs(char src, char dest) {
		if (src == dest) {
			return true;
		}
		Set<Character> marked = new HashSet();
		helper(src, marked);
		if (marked.contains(dest)) {
			return true;
		}
		return false;
	}

	private void helper(char src, Set<Character> marked) {
		if (!marked.contains(src)) {
			marked.add(src);
			if (equals.containsKey(src)) {
				for (char c : equals.get(src)) {
					helper(c, marked);
				}
			}
		}
	}

	private Map<Character, List<Character>> getEquals(String[] eq) {
		Map<Character, List<Character>> equals = new HashMap();
		for (String s : eq) {
			char one = s.charAt(0);
			char two = s.charAt(3);
			char ch = s.charAt(1);
			if (ch == '=') {
				if (!equals.containsKey(one)) {
					List<Character> list = new ArrayList();
					list.add(two);
					equals.put(one, list);
				} else {
					equals.get(one).add(two);
				}
				if (!equals.containsKey(two)) {
					List<Character> list = new ArrayList();
					list.add(one);
					equals.put(two, list);
				} else {
					equals.get(two).add(one);
				}
			}
		}
		return equals;
	}
}
