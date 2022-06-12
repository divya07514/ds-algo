package ds_algo.divya.leetcode.practice;

public class SplitaStringinBalancedStrings {

	public static int balancedStringSplit(String s) {
		int result = 0;
		int rc = 0;
		int lc = 0;
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch == 'R') {
				rc++;
				i++;
			}
			if (ch == 'L') {
				lc++;
				i++;
			}
			if (lc == rc) {
				result++;
				rc = 0;
				lc = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "RLRRRLLRLL";
		System.out.println(balancedStringSplit(s));

	}

}
