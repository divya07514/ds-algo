package medium;

public class NumberOfProvinces {
	public static int findCircleNum(int[][] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int count = 0;
		boolean[] marked = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!marked[i]) {
				dfs(i, nums, marked);
				count++;
			}
		}
		return count;
	}
	private static void  dfs(int s, int[][] nums, boolean[] marked) {
		marked[s] = true;
		for (int i = 0; i < nums[s].length; i++) {
			if (nums[s][i] == 1 && i != s && !marked[i]) {
				marked[i] = true;
				dfs(i, nums, marked);
			}
		}
	}
	public static void main(String[] args) {
		int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(isConnected));
	}

}
