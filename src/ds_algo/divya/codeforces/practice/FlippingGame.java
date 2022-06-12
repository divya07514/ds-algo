package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class FlippingGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] nums = new int[n];

		int sum = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			nums[index++] = input;
			sum = sum + input;
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			int current = sum;
			for (int j = i; j < n; j++) {
				if(nums[j]==1) {
					current = current -1;
				}else {
					current = current + 1;
				}
				result= Math.max(result, current);
			}
			
		}
		System.out.println(result);
	}

}
