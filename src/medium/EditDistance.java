package medium;

public class EditDistance {

	public int minDistance(String one, String two) {

		Integer[][] dp = new Integer[one.length() + 1][two.length() + 1];
		return min(one, one.length(), two, two.length(), dp);
	}

	private int min(String one, int i, String two, int j, Integer[][] dp) {
		if (i == 0) {
			return j;
		}
		if (j == 0) {
			return i;
		}
		if (dp[i][j] != null) {
			return dp[i][j];
		}

		int dist = 0;

		if (one.charAt(i - 1) == two.charAt(j - 1)) {
			dist = min(one, i - 1, two, j - 1, dp);
		} else {
			int insert = min(one, i, two, j - 1, dp);
			int delete = min(one, i - 1, two, j, dp);
			int replace = min(one, i - 1, two, j - 1, dp);
			dist = Math.min(insert, Math.min(delete, replace)) + 1;
		}
		dp[i][j] = dist;
		return dp[i][j];
	}

}
