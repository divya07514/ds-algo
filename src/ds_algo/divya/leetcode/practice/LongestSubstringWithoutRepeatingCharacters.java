package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		if (s==null) {
			return 0;
		}
		if(s.length()==0) {
			return 0;
		}
		if(s.length()==1) {
			return 1;
		}
		int max = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<Character>();
		int i = 0;
		int j = 0;
		while (i< s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				max = Math.max(max, j-i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		if(i==0 && j==s.length()) {
			max = j-i;
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
