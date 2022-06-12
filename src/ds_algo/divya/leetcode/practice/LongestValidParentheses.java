package ds_algo.divya.leetcode.practice;

import java.util.Stack;

public class LongestValidParentheses {

	public static int longestValidParentheses(String str) {
		if (str.isEmpty() || str == null) {
			return 0;
		}
		int n = str.length();
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '(')
				stk.push(i);
			else {
				stk.pop();
				if (!stk.empty())
					result = Math.max(result, i - stk.peek());
				else
					stk.push(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(longestValidParentheses(s));

	}

}
