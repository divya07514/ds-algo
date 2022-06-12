package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	public static boolean canPermutePalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}
		Map<Character, Integer> map = new HashMap<>();
		boolean onlyOne = true;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
				onlyOne = false;
			}
		}

		if (onlyOne) {
			return false;
		}
		int countOdd = 0;
		for (char c : map.keySet()) {
			int val = map.get(c);
			if (val % 2 == 1) {
				countOdd++;
			}
		}
		if (countOdd > 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "ab";
		System.out.println(canPermutePalindrome(s));
	}

}
