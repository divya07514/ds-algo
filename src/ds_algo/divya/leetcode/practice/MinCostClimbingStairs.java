package ds_algo.divya.leetcode.practice;

public class MinCostClimbingStairs {
	public static int minCostClimbingStairs(int[] cost) {
		if(cost==null || cost.length==0) {
			return 0;
		}
		int[] dp = new int[cost.length + 1];
		dp[0] = cost[0];
		dp[1] = Math.min(dp[0] + cost[1], cost[1]);

		for (int i = 2; i < cost.length; i++) {
			int one = dp[i - 1] + cost[i];
			int two = dp[i - 2] + cost[i];
			dp[i] = Math.min(one, two);
		}
		
		dp[dp.length - 1] = Math.min(dp[dp.length-2], dp[dp.length-3]);
		
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs(cost));

	}

}
