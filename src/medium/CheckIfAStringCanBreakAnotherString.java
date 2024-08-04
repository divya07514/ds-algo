package medium;

import java.util.Arrays;

public class CheckIfAStringCanBreakAnotherString {

	public static boolean checkIfCanBreak(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}
		char[] one = s1.toCharArray();
		char[] two = s2.toCharArray();
		Arrays.sort(one);
		Arrays.sort(two);

		if (check(one, two)) {
			return true;
		}
		if (check(two, one)) {
			return true;
		}
		return false;
	}

	private static boolean check(char[] one, char[] two) {
		for (int i = 0; i < one.length; i++) {
			if (one[i] < two[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "xya";
		System.out.println(checkIfCanBreak(s1, s2));

	}

}
