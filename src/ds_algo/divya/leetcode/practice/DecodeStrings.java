package ds_algo.divya.leetcode.practice;

import java.util.Stack;

public class DecodeStrings {

	public static String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String result = "";
		Stack<Integer> nums = new Stack<Integer>();
		Stack<String> str = new Stack<String>();
		int index = 0;
		while (index < s.length()) {
			char ch = s.charAt(index);
			if (Character.isDigit(ch)) {
				StringBuilder sb = new StringBuilder();
				while (Character.isDigit(s.charAt(index))) {
					sb.append(s.charAt(index));
					index++;
				}
				int count = Integer.parseInt(sb.toString());
				nums.push(count);

			} else if (ch == '[') {
				str.push(result);
				result = "";
				index++;

			} else if (ch == ']') {
				int count = nums.pop();
				StringBuilder sb = new StringBuilder();
				while (count > 0) {
					sb.append(result);
					count--;
				}
				result = str.pop() + sb.toString();
				index++;
			} else {
				result = result + String.valueOf(ch);
				index++;
			}

		}

		return result;
	}

	public static void main(String[] args) {

		String s = "100[leetcode]";
		 //String s = "abc3[cd]xyz";
		System.out.println(decodeString(s));

	}

}
