package ds_algo.divya.leetcode.practice;

public class UniqueBinarySearchTrees {

	/**
	 * Application of Catalan Numbers.
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
		
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=n;i++) {
			dp[i]=0;
			for(int j=1;j<=i;j++) {
				int left = dp[j-1];
				int right = dp[i-j];
				dp[i] = dp[i] + left*right;
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int n =4;
		System.out.println(numTrees(n));
	}

}
