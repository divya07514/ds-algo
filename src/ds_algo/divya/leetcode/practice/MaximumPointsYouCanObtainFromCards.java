package ds_algo.divya.leetcode.practice;

public class MaximumPointsYouCanObtainFromCards {

	public static int maxScore(int[] cards, int k) {
		int n = cards.length;
		for (int i = 1; i < n; i++) {
			cards[i] = cards[i - 1] + cards[i];
		}

		if (k == n) {
			return cards[n - 1];
		}

		int left = 0;
		int min = cards[n - k - 1];
		int window = n - k;

		while (window < n) {
			int next = cards[window++];
			int prev = cards[left++];
			min = Math.min(min, next - prev);
		}

		return cards[n - 1] - min;
	}

	public static void main(String[] args) {
		int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
		int k = 3;
		System.out.println(maxScore(cardPoints, k));
	}

}
