package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {
	
	static int count =0;
	
	public static int countSubstrings(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		count(s);
		int result = count;
		count = 0;
		return result;
	}
	
	private static void count(String s) {
		int left = 0;
		int right = 1;
		Set<String> set = new HashSet<>();
		while(left < s.length()) {
			if(right > s.length()) {
				left++;
				right = left +1;
				continue;
			}
			String temp = s.substring(left, right);
			checkPalindrome(temp,set);
			right++;
		}
		
	}

	public static void checkPalindrome(String s,Set<String> set ) {
		int left = 0;
		int right = s.length()-1;
		while(left <= right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return;
			}
			;
			if(left+1 < right) {
				String inner = s.substring(left+1, right);
				if(set.contains(inner)) {
					count = count + 1;
					set.add(s);
					return;
				}
			}
			left++;
			right--;
		}
		count = count + 1;
		set.add(s);
	}

	public static void main(String[] args) {
		String s = "abc";
		System.out.println(countSubstrings(s));

	}

}
