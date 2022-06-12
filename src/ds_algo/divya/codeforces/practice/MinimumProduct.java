package ds_algo.divya.codeforces.practice;

import java.math.BigInteger;
import java.util.Scanner;

public class MinimumProduct {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int n = sc.nextInt();
			BigInteger resultA = getProduct(a, b, x, y, n);
			BigInteger resultB = getProduct(b, a, y, x, n);
			BigInteger result = resultA.min(resultB);
			System.out.println(result);
		}

	}

	private static BigInteger getProduct(int a, int b, int x, int y, int n) {
		int z = Math.min(a - x, n);
		a = a - z;
		n = n - z;
		z = Math.min(b - y, n);
		b = b - z;
		BigInteger one = new BigInteger(String.valueOf(a));
		BigInteger two = new BigInteger(String.valueOf(b));
		return one.multiply(two);
	}

}


