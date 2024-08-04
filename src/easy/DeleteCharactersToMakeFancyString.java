package easy;

import java.util.LinkedList;

public class DeleteCharactersToMakeFancyString {

	public static String makeFancyString(String s) {
		if (s == null || s.length() == 0 || s.length() <= 2) {
			return s;
		}
		LinkedList<Character> stack = new LinkedList();
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
			} else if (stack.peek() == c) {
				count++;
				stack.push(c);
				if (count == 3) {
					stack.pop();
					count--;
				}
			} else {
				count = 1;
				stack.push(c);
			}
		}

		char[] array = new char[stack.size()];
		int index = stack.size() - 1;
		while (!stack.isEmpty()) {
			array[index--] = stack.pop();
		}

		return new String(array);
	}

	public static void main(String[] args) {
		String s = "aaabaaaa";
		System.out.println(makeFancyString(s));

	}

}
