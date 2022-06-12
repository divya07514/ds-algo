package ds_algo.divya.leetcode.practice;

public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		boolean result = false;
		int index = 0;
		for (int i = 0; i < t.length(); i++) {
			if (!s.isEmpty()&& index<s.length() &&s.charAt(index) == t.charAt(i)) {
				index++;
			}
		}
		if (index == s.length()) {
			result = true;
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "adc";
		
		String t = "ahbgdc";
		System.out.println(isSubsequence(s, t));

	}

}
