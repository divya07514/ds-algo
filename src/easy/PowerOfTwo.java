package easy;

public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {

		if (n == 1) {
			return true;
		}
		if (n % 2 != 0 || n == 0 || n < 0) {
			return false;
		}
		return power(n);
	}

	private static boolean power(int n) {
		if (n % 2 != 0) {
			return false;
		}
		if (n / 2 == 1 && n % 2 == 0) {
			return true;
		}
		return power(n / 2);
	}

// Leetcode discussion
	public boolean isPowerOfTwo_leetcode(int n) {
		if (n == 0) {
			return false;
		}
		while (n % 2 == 0) {
			n = n / 2;
		}

		return n == 1;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(0));

	}

}
