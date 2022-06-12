package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class MinimumAddToMakeParenthesesValid {

	public static int minAddToMakeValid(String s) {

		if (s.isEmpty()) {
			return 0;
		}
		int count = 0;

		LinkedList<Character> stack = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(ch);
			} else if (ch == ')') {
				if (stack.peek() == '(' && !stack.isEmpty()) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}
		count = stack.size();
		return count;
	}

	public static void main(String[] args) {
		String s = "(()";
		System.out.println(minAddToMakeValid(s));

	}

}
