package ds_algo.divya.leetcode.practice;

public class RomanToInteger {
	public static int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int sum = 0;
		int index = 0;
		while (index < s.length()) {
			char ch = s.charAt(index);
			if (ch == 'I' && index + 1 < s.length() && s.charAt(index + 1) == 'V') {
				sum = sum + 4;
				index = index + 2;
				continue;
			}
			if (ch == 'I' && index + 1 < s.length() && s.charAt(index + 1) == 'X') {
				sum = sum + 9;
				index = index + 2;
				continue;
			}

			if (ch == 'X' && index + 1 < s.length() && s.charAt(index + 1) == 'L') {
				sum = sum + 40;
				index = index + 2;
				continue;
			}
			if (ch == 'X' && index + 1 < s.length() && s.charAt(index + 1) == 'C') {
				sum = sum + 90;
				index = index + 2;
				continue;
			}
			if (ch == 'C' && index + 1 < s.length() && s.charAt(index + 1) == 'D') {
				sum = sum + 400;
				index = index + 2;
				continue;
			}
			if (ch == 'C' && index + 1 < s.length() && s.charAt(index + 1) == 'M') {
				sum = sum + 900;
				index = index + 2;
				continue;
			}
			if (ch == 'I') {
				sum = sum + 1;
				index = index + 1;
				continue;
			}
			if (ch == 'V') {
				sum = sum + 5;
				index = index + 1;
				continue;
			}
			if (ch == 'X') {
				sum = sum + 10;
				index = index + 1;
				continue;
			}
			if (ch == 'L') {
				sum = sum + 50;
				index = index + 1;
				continue;
			}
			if (ch == 'C') {
				sum = sum + 100;
				index = index + 1;
				continue;
			}
			if (ch == 'D') {
				sum = sum + 500;
				index = index + 1;
				continue;
			}
			if (ch == 'M') {
				sum = sum + 1000;
				index = index + 1;
				continue;
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		String s = "III";
		System.out.println(romanToInt(s));

	}

}
