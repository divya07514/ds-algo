package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

	public static List<Integer> findAnagrams(String s, String p) {
		if (p.length() > s.length()) {
			return new ArrayList<Integer>();
		}
		List<Integer> result = new ArrayList<Integer>();
		int[] countP = new int[26];
		int[] countS = new int[26];
		int len = p.length();
		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			countP[ch - 'a']++;
		}
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			char ch = s.charAt(right);
			countS[ch - 'a']++;
			if (right - left + 1 == len) {
				if (Arrays.equals(countP, countS)) {
					result.add(left);
				}
				countS[s.charAt(left) - 'a']--;
				left++;
			}
			right++;
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p));
	}

}
