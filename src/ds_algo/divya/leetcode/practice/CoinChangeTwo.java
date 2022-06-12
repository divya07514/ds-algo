package ds_algo.divya.leetcode.practice;

import java.util.Arrays;

public class CoinChangeTwo {

	static int result;

	/**
	 * Self implemented solution. This is exploring whole search space. Hence, very
	 * time consuming process.
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public static int change_tle(int amount, int[] coins) {
		if (amount == 0 && coins.length == 0) {
			return 1;
		}
		if (amount != 0 && coins.length == 0) {
			return 0;
		}

		Arrays.sort(coins);
		result = 0;
		int current = 0;
		int index = 0;
		backTrack(current, index, amount, coins);
		return result;

	}

	public static void backTrack(int current, int index, int amount, int[] coins) {
		if (index >= coins.length) {
			return;
		}
		if (current > amount) {
			return;
		}
		current = current + coins[index];
		if (current == amount) {
			result = result + 1;
			return;
		}
		backTrack(current, index, amount, coins);
		current = current - coins[index];
		backTrack(current, index + 1, amount, coins);
	}

	/**
	 * Leet code solution.
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public static int change(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin : coins) {
			for (int x = coin; x < amount + 1; x++) {
				dp[x] = dp[x] + dp[x - coin];
			}
		}

		return dp[amount];
	}

	public static void main(String[] args) {
		int amount = 5;
		int[] coins = { 1, 2, 5 };
		System.out.println(change_tle(amount, coins));
		System.out.println(change(amount, coins));
	}

}
