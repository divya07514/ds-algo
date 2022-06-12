package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses {
	
	public static String reverseParentheses(String s) {
		if (s.isEmpty()) {
			return s;
		}
		LinkedList<String> stack = new LinkedList<>();
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				str = str + ch;
			} else if (ch == '(') {
				stack.push(str);
				str = "";
			} else {
				String reverse = new StringBuilder(str).reverse().toString();
				String p = stack.pop();
				str = p + reverse;
			}
		}

		return str;
	}

	public static void main(String[] args) {
		String s = "(ed(et(oc))el)";
		System.out.println(reverseParentheses(s));

	}

}
