package medium;

public class UniqueBinarySearchTrees {

	public static int numTrees(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int count = getCount(i, dp);
			dp[i] = count;
		}

		return dp[n];
	}

	private static int getCount(int temp, int[] dp) {
        int sum = 0;
        for(int i=0;i<temp;i++){
            if(i==0){
                int left= 1;
                int j = temp-1;
                int right = dp[j];
                sum = sum + (left*right);
                continue;
            }
            if(i==temp-1){
                int right=1;
                int j = temp-1;
                int left = dp[j];
                sum = sum + (left*right); 
                continue;
            }
            int left = i;
            int right = temp-1-i;
            sum = sum + (dp[left]*dp[right]);
        }
        return sum;
	}

	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(numTrees(n));
	}

}
