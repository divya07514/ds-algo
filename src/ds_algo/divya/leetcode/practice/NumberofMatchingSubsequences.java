package ds_algo.divya.leetcode.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberofMatchingSubsequences {

	/**
	 * Time Limit Exceeds in this implementation
	 * 
	 * @param S
	 * @param words
	 * @return
	 */
	public static int numMatchingSubseq_TLE(String S, String[] words) {
		int count = 0;
		int n = S.length();
		for (String temp : words) {
			int index = 0;
			int i = 0;
			while (i < n) {
				if (index < temp.length() && S.charAt(i) == temp.charAt(index)) {
					i++;
					index++;
				} else {
					i++;
				}
			}
			if (index == temp.length()) {
				count++;
			}
		}
		return count;
	}


	public static void main(String[] args) {
		String S = "abcde";
		String[] words = {"a", "bb", "acd", "ace"};
		System.out.println(numMatchingSubseq_TLE(S, words));

	}

}
