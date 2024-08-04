package easy;

public class ValidPalindromeII {

	public static boolean validPalindrome(String s) {
		boolean result = true;
		if (s == null) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		boolean left = true;
		boolean right = true;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
				continue;
			}
			left = check(s.substring(i, j));
			right = check(s.substring(i + 1, j + 1));

			if (!left && !right) {
				return false;
			} else if (left || right) {
				return true;
			}
		}
		return result;
	}

	private static boolean check(String s) {
		char[] array = s.toCharArray();
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if (array[i] != array[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "abccbxa";
		System.out.println(validPalindrome(s));

	}

}
