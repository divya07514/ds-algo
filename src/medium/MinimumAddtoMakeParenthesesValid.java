package medium;

import java.util.LinkedList;

public class MinimumAddtoMakeParenthesesValid {

	public int minAddToMakeValid(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}

		LinkedList<Character> stack = new LinkedList();
		int count = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					count++;
				} else {
					stack.pop();
				}

			}
		}
		return count + stack.size();

	}
}
