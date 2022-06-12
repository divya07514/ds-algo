package ds_algo.divya.leetcode.practice;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack();
		for (String s : tokens) {
			if (s.equals("+")) {
				int one = stack.pop();
				int two = stack.pop();
				stack.push(one + two);
				continue;
			}
			if (s.equals("-")) {
				int one = stack.pop();
				int two = stack.pop();
				stack.push(two - one);
				continue;
			}
			if (s.equals("/")) {
				int one = stack.pop();
				int two = stack.pop();
				stack.push(two / one);
				continue;
			}
			if (s.equals("*")) {
				int one = stack.pop();
				int two = stack.pop();
				stack.push(one * two);
				continue;
			}
			stack.push(Integer.parseInt(s));
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(tokens));

	}

}
