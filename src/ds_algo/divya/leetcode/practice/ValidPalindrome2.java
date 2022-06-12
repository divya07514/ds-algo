package ds_algo.divya.leetcode.practice;

public class ValidPalindrome2 {

	public static boolean validPalindrome(String s) {
		if(s==null) {
			return false;
		}
		if(s.isEmpty()||s.length()==1) {
			return true;
		}
		boolean result = false;
		if (checkPalindrom(s)) {
			return true;
		}
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
				continue;
			} else {
				boolean leftR = false;
				boolean rightR = false;
				if (checkLeft(left, right, s)) {
					return true;
				}else {
					leftR=false;
				}
				if (checkRight(left, right, s)) {
					return true;
				}else {
					rightR=false;
				}
				if(!leftR && !rightR) {
					return false;
				}
			}
		}
		return result;
	}

	private static boolean checkRight(int left, int right, String s) {
		String temp = s.substring(0, left) + s.substring(left + 1, s.length());
		if (checkPalindrom(temp)) {
			return true;
		}
		return false;
	}

	private static boolean checkLeft(int left, int right, String s) {
		String temp = s.substring(0, right) + s.substring(right + 1,s.length());
		if (checkPalindrom(temp)) {
			return true;
		}
		return false;
	}

	private static boolean checkPalindrom(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aba";
		System.out.println(validPalindrome(s));

	}

}
