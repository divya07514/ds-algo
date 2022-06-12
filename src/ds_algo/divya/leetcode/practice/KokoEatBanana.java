package ds_algo.divya.leetcode.practice;

public class KokoEatBanana {

	public static int minEatingSpeed(int[] piles, int hrs) {

		if (piles == null || piles.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int n = piles.length;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, piles[i]);
		}

		int left = 1;
		int right = max;

		while (left < right) {
			int mid = left + (right - left) / 2;
			boolean canEat = eat(mid, piles, hrs);
			if (!canEat) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;

	}

	public static boolean eat(int mid, int[] piles, int hrs) {
		int count = 0;
		boolean canEat = false;
		for (int i : piles) {
			count = count + (int) Math.ceil((int) (double) i / (double) mid);
		}
		if (count <= hrs) {
			canEat = true;
		}
		return canEat;
	}

	public static void main(String[] args) {
		int[] piles = { 3, 6, 7, 11 };
		int hrs = 8;
		System.out.println(minEatingSpeed(piles, hrs));
	}

}
