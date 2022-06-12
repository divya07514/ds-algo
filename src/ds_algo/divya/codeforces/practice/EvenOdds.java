package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class EvenOdds {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		long n = scanner.nextLong();
		long k = scanner.nextLong();

		long mid = 0;

		if (n % 2 == 0) {
			mid = n / 2;
		} else {
			mid = (n / 2) + 1;
		}

		long num = 0;

		if (k <= mid) {
			num = 1 + (k - 1) * 2;
		} else {
			long even = k - mid;
			num = 2 + (even - 1) * 2;
		}

		System.out.println(num);
		scanner.close();
	}

}
