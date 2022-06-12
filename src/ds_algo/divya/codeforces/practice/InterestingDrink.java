package ds_algo.divya.codeforces.practice;

import java.util.Arrays;
import java.util.Scanner;

public class InterestingDrink {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] shops = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			shops[index++] = sc.nextInt();
		}
		Arrays.sort(shops);
		int q = sc.nextInt();
		int[] coins = new int[q];
		index = 0;
		for (int i = 0; i < q; i++) {
			coins[index++] = sc.nextInt();
		}

		for (int coin : coins) {
			int result = getResult(coin, shops);
			System.out.println(result);
		}

	}

	private static int getResult(int coin, int[] shops) {
		if (coin < shops[0]) {
			return 0;
		}
		if (coin > shops[shops.length - 1]) {
			return shops.length;
		}
		int left = 0;
		int right = shops.length - 1;
		int result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (shops[mid] <= coin) {
				result = mid + 1;
				left = mid + 1;
			} else if (shops[mid] > coin) {
				right = mid - 1;
			}

		}

		return result;
	}

}
