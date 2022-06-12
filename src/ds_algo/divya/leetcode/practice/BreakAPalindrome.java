package ds_algo.divya.leetcode.practice;

public class BreakAPalindrome {

	public static String breakPalindrome(String palindrome) {
		char[] array = palindrome.toCharArray();
		for (int i = 0; i < array.length / 2; i++) {
			char c = array[i];
			if (c - 'a' == 0) {
				continue;
			} else {
				array[i] = 'a';
				return new String(array);
			}
		}
		
		if(palindrome.length() > 1) {
			array[array.length -1] = 'b';
			return new String(array);
		}
		
		return "";
	}

	public static void main(String[] args) {
		String s = "a";
		System.out.println(breakPalindrome(s));

	}

}
