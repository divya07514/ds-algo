package ds_algo.divya.leetcode.practice;

public class RepeatedStringMatch {

	public static int repeatedStringMatch(String A, String B) {
		if (A == null || A.length() == 0 || B == null || B.length() == 0) {
			return -1;
		}
		int count = 1;
		StringBuilder sb = new StringBuilder(A);
		while (sb.toString().length() < B.length()) {
			sb.append(A);
			count++;
		}

		if (sb.indexOf(B) >= 0) {
			return count;
		}
		if (sb.append(A).indexOf(B) >= 0) {
			return count + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		String A = "abcd";
		String B = "cdabcdab";

		System.out.println(repeatedStringMatch(A, B));

	}

}
