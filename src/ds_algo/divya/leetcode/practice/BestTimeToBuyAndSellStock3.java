package ds_algo.divya.leetcode.practice;

public class BestTimeToBuyAndSellStock3 {

	static public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] forward = getForwardBestPrice(prices);
		int[] backward = getBackWardBestPrice(prices);
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i - 1 == -1) {
				i = 0;
				maxProfit = Math.max(maxProfit, forward[0] + backward[0]);
			} else {
				maxProfit = Math.max(maxProfit, forward[i - 1] + backward[i]);
			}
		}
		return maxProfit;
	}

	private static int[] getBackWardBestPrice(int[] prices) {
		int[] backward = new int[prices.length];
		int profit = 0;
		int maxPrice = Integer.MIN_VALUE;
		for (int i = backward.length - 1; i >= 0; i--) {
			maxPrice = Math.max(maxPrice, prices[i]);
			profit = Math.max(profit, maxPrice - prices[i]);
			backward[i] = profit;
		}
		return backward;
	}

	private static int[] getForwardBestPrice(int[] prices) {
		int[] forward = new int[prices.length];
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < forward.length; i++) {
			profit = Math.max(profit, prices[i] - minPrice);
			minPrice = Math.min(prices[i], minPrice);
			forward[i] = profit;
		}
		return forward;
	}

	public static void main(String[] args) {
		int prices[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(maxProfit(prices));
	}

}
