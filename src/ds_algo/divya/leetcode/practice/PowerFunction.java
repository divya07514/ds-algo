package ds_algo.divya.leetcode.practice;

public class PowerFunction {

	public static double myPow(double x, long n) {
		return pow(x, n);
	}

	public static double pow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		if (n == 1) {
			return x;
		}
		if (x == 1) {
			return 1;
		}
		if (n < 0) {
			return pow(1 / x, -n);
		}
		double result = pow(x * x, n / 2);
		if (n % 2 != 0) {
			result = result * x;
		}
		return result;

	}

	public static void main(String[] args) {
		double x = 2.00000;
		long n = -2147483648;
		System.out.println(myPow(x, n));
	}

}
