package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateLetters {
	
	public String removeDuplicateLetters(String s) {
		int n = s.length();
		if (n == 0 || n == 1) {
			return s;
		}

		Map<Character, Integer> map = new HashMap();
		for (int i = 0; i < n; i++) {
			map.put(s.charAt(i), i);
		}
		LinkedList<Character> stack = new LinkedList();
		Set<Character> set = new HashSet();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
					set.remove(stack.pop());
				}
				stack.push(c);
				set.add(c);
			}
		}
		String result = "";
		while (!stack.isEmpty()) {
			result = String.valueOf(stack.pop()) + result;
		}

		return result;
	}
}
