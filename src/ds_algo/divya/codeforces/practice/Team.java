package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class Team {

	public static int solved(int[] input) {
		int a = input[0];
		int b = input[1];
		int c = input[2];
		if (a + b + c >= 2) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result = 0;
		for (int i = 0; i < n; i++) {
			int[] input = new int[3];
			int index = 0;
			for (int j = 0; j < 3; j++) {
				String s = scanner.next();
				input[index++] = Integer.parseInt(s);
			}
			result = result + solved(input);

		}
		System.out.println(result);
		scanner.close();
	}

}
