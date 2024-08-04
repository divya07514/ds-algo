package easy;

public class CountBinarySubstrings {

	public static int countBinarySubstrings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int count = 0;
		int i = 1;
		int prev = 0;
		int curr = 1;

		while (i < s.length()) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				count = count + Math.min(prev, curr);
				prev = curr;
				curr = 1;
			} else {
				curr++;
			}
			i++;
		}

		return count + Math.min(prev, curr);
	}

	public static void main(String[] args) {
		String s = "00110011";
		System.out.println(countBinarySubstrings(s));

	}

}
