package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class PashmakAndGarden {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		if (a != c && b != d && Math.abs(a - c) != Math.abs(b - d)) {
			System.out.println(-1);
		} else if (a == c) {
			int p = a + Math.abs(b - d);
			int q = b;
			int r = c + Math.abs(b - d);
			int s = d;
			System.out.println(p + " " + q + " " + r + " " + s);
		} else if (b == d) {
			int p = a;
			int q = b + Math.abs(a - c);
			int r = c;
			int s = d + +Math.abs(a - c);
			System.out.println(p + " " + q + " " + r + " " + s);
		}else {
			int p = a;
			int q = d;
			int r = c;
			int s = b;
			System.out.println(p + " " + q + " " + r + " " + s);
		}

	}

}
