package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class IlyaandQueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] array = s.toCharArray();

		int[] sum = new int[s.length()];
		sum[0] = 0;
		for (int i = 1; i < sum.length; i++) {
			if (array[i - 1] == array[i]) {
				sum[i] = sum[i - 1] + 1;
			} else {
				sum[i] = sum[i - 1];
			}
		}

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			int result = sum[right - 1] - sum[left - 1];
			System.out.println(result);
		}
	}

}
