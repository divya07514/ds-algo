package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class TheatreSquare {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();
		int a = s.nextInt();

		if (n < a && m < a) {
			System.out.println(1);
			return;
		}

		long result = count(n, a) * count(m, a);
		System.out.println(result);
	}

	public static long count(int n, int a) {
		long count = 0;

		long quotient = n / a;
		count = count + quotient;

		if (n % a > 0) {
			count = count + 1;
		}

		return count;
	}

}
