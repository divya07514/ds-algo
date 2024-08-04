package easy;

public class GreatestCommonDivisorOfStrings {
	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	public static String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1))
			return "";
		int len1 = str1.length();
		int len2 = str2.length();
		int gcd = gcd(len1, len2);

		return str1.substring(0, gcd);
	}

	public static void main(String[] args) {
		String str1 = "ABCABC";
		String str2 = "ABC";
		System.out.println(gcd(0, 0));

	}

}
