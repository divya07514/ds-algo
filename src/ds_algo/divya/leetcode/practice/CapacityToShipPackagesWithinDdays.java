package ds_algo.divya.leetcode.practice;

public class CapacityToShipPackagesWithinDdays {

	static public int shipWithinDays(int[] weights, int D) {
		int totalWeight = 0;
		int maxWeight = Integer.MIN_VALUE;
		for (int w : weights) {
			totalWeight = totalWeight + w;
			maxWeight = Math.max(w, maxWeight);
		}
		int minWeight = maxWeight;
		while (!canShip(weights, D, minWeight)) {
			minWeight++;
		}
		return minWeight;
	}

	public static int shipWithinDays_binary_search(int[] weights, int D) {
		int totalWeight = 0;
		int maxWeight = Integer.MIN_VALUE;
		for (int i = 0; i < weights.length; i++) {
			totalWeight = totalWeight + weights[i];
			maxWeight = Math.max(maxWeight, weights[i]);
		}
		int ans = 0;
		while (maxWeight <= totalWeight) {
			int mid = (totalWeight + maxWeight) / 2;
			boolean result = canShip(weights, D, mid);
			if (result) {
				totalWeight = mid - 1;
				ans = mid;
			} else {
				maxWeight = mid + 1;
			}
		}
		return ans;
	}

	private static boolean canShip(int[] weights, int D, int minWeight) {
		int currentWeight = 0;
		int days = 1;
		for (int w : weights) {
			currentWeight = currentWeight + w;
			if (currentWeight > minWeight) {
				days++;
				if (days > D) {
					return false;
				}
				currentWeight = w;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int D = 5;
		System.out.println(shipWithinDays(weights, D));
		System.out.println(shipWithinDays_binary_search(weights, D));
	}

}
