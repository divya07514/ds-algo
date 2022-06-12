package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {
	
	public static String reformat(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		List<Character> digits = new ArrayList<>();
		List<Character> letters = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				digits.add(ch);
			} else {
				letters.add(ch);
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int digitSize = digits.size();
		int letterSize = letters.size();
		while (digitSize > 0 && letterSize > 0) {
			char digit = digits.get(i);
			char letter = letters.get(i);
			if(letterSize>digitSize) {
				sb.append(letter);
				sb.append(digit);
			}else {
				sb.append(digit);
				sb.append(letter);
			}
			i++;
			digitSize--;
			letterSize--;
		}
		if (digitSize> 1 || letterSize > 1) {
			return "";
		}
		if (digitSize == 1) {
			sb.append(digits.get(i));
		}
		if (letterSize == 1) {
			sb.append(letters.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s  = "j";
		System.out.println(reformat(s));

	}

}
