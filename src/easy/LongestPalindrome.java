package easy;

public class LongestPalindrome {

	public static int longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int count = 0;
		int[] array = new int[128];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (++array[c] == 2) {
				count = count + 2;
				array[c] = 0;
			}
		}
		return (count == s.length()) ? count : count + 1;
	}

	public static void main(String[] args) {
		String s = "abccccdd";
		System.out.println(longestPalindrome(s));

	}

}
