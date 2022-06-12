package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class CheapTravel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int result = 0;

		while(n!=0) {
			int x = Math.min(n, m);
			result = result + Math.min(x*a,b);
			n= n -x;
		}


		System.out.println(result);
	}
}
