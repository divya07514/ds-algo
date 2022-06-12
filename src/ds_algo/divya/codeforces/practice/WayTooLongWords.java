package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class WayTooLongWords {

	public static void words(String s) {
		int length = s.length();
		int count = length - 2;
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0)).append(count).append(s.charAt(length-1));
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for (int i = 0; i <= count; i++) {
			String input = scanner.nextLine();
			if (input.length() < 11) {
				System.out.println(input);
			} else {
				words(input);
			}
		}
		scanner.close();
	}
}
