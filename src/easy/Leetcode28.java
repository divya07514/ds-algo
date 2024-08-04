package easy;

public class Leetcode28 {

	public static int strStr(String s, String p) {

		if (p.length() > s.length()) {
			return -1;
		}

		if (s.equals(p)) {
			return 0;
		}

		int i = 0;
		int j = 0;
		int result = -1;

		while (i < s.length()) {
			if (s.charAt(i) != p.charAt(j)) {
				i++;
				continue;
			} else {
				int k = i;
				while (k < s.length() && j < p.length() && s.charAt(k) == p.charAt(j)) {
					k++;
					j++;
				}
				if (j >= p.length()) {
					result = k - p.length();
					break;
				} else {
					j = 0;
				}
				i++;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		String s ="mississippi";
		String p = "issip";
		System.out.println(strStr(s, p));
	}

}
