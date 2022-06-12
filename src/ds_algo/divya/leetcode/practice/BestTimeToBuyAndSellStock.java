package ds_algo.divya.leetcode.practice;

public class BestTimeToBuyAndSellStock {

	static public int maxProfit(int[] prices) {
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int price : prices) {
			profit = Math.max(profit, price - minPrice);
			minPrice = Math.min(price, minPrice);
		}
		return profit;
	}

	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));

	}

}
