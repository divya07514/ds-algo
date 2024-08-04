package medium;

import java.util.LinkedList;

public class DecodeString {

	public String decodeString(String s) {

		if (s.length() == 0) {
			return "";
		}

		LinkedList<Integer> count = new LinkedList();
		LinkedList<String> ss = new LinkedList();
		int num = 0;
		String current = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10;
				num = num + c - '0';
			} else if (c == '[') {
				count.push(num);
				ss.push(current);
				num = 0;
				current = "";
			} else if (c == ']') {
				StringBuilder sb = new StringBuilder();
				int total = count.pop();
				String top = ss.pop();
				sb.append(top);
				while (total > 0) {
					sb.append(current);
					total--;
				}
				current = sb.toString();
			} else {
				current = current + c;
			}
		}

		return current;

	}

}
