package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockWithCooldown {

	public static int maxProfit(int[] prices) {
		if(prices==null || prices.length==0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = prices.length;
		int result =  max(prices,0,map,n);
		System.out.println(map);
		return result;
	}

	private static int max(int[] prices, int current, Map<Integer, Integer> map, int n) {
		if(current>=n) {
			return 0;
		}
		if(map.containsKey(current)) {
			return map.get(current);
		}
		int max = 0;
		for(int i=current+1;i<n;i++) {
			if(prices[current] < prices[i]) {
				max = Math.max(max, prices[i] - prices[current]+max(prices, i+2, map, n));
			}
		}
		max = Math.max(max, max(prices, current+1, map, n));
		map.put(current, max);
		return map.get(current);
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 0, 2};
		System.out.println(maxProfit(prices));
	}

}
