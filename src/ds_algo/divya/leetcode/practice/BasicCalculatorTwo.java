package ds_algo.divya.leetcode.practice;

import java.util.Stack;

public class BasicCalculatorTwo {

	public static int calculate(String s) {
		/*
		 * make two passes through the string, in first pass handle the * and / from
		 * left to right keep pushing the result on to the stack and then in the second
		 * pass handle the + and - from left to right pushing the result on to the
		 * stack.
		 */
		if (s.length() == 1) {
			return Integer.parseInt(s);
		}
		final Stack<String> stack = new Stack<>();
		int index = 0;
		while (index < s.length()) {
			final char ch = s.charAt(index);
			if (Character.isDigit(ch)) {
				int num = getDigit(s, index);
				String n = String.valueOf(num);
				index += n.length() - 1;
				if (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
					if (num != 0) {
						String operation = stack.pop();
						int num2 = Integer.parseInt(stack.pop());
						if (operation.equals("*")) {
							num = num * num2;
						} else {
							num = num2 / num;
						}
					}
				}
				stack.push(num + "");
			} else if (ch != ' ') {
				stack.push(ch + "");
			}
			index++;
		}
		Stack<String> stack2 = new Stack<>();
		while (!stack.isEmpty()) {
			stack2.push(stack.pop());
		}
		int result = Integer.parseInt(stack2.pop());
		while (stack2.size() > 1) {
			String operation = stack2.pop();
			int num = Integer.parseInt(stack2.pop());

			if (operation.equals("+")) {
				result += num;
			} else {
				result -= num;
			}
		}
		return result;
	}

	public static int getDigit(String s, int index) {
		char ch = s.charAt(index);
		int num = 0;
		while (index < s.length() && Character.isDigit(ch)) {
			num = num * 10 + ch - '0';
			if (++index < s.length())
				ch = s.charAt(index);
		}
		return num;
	}

	public static void main(String[] args) {
		String s = "3+5/2+3*5+4/2+2";
		System.out.println(calculate(s));

	}

}
