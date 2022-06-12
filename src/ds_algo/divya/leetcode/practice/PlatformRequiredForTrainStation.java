package ds_algo.divya.leetcode.practice;

public class PlatformRequiredForTrainStation {

	private static int countPlatforms(int[] arrival, int[] departure) {
		int platform = 0;
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		int n = arrival.length;
		while (left < n && right < n) {
			if (arrival[right] <= departure[left]) {
				platform++;
				right++;
			} else if (arrival[right] >= departure[left]) {
				platform--;
				left++;
			}
			max = Math.max(max, platform);

		}
		return max;
	}

	public static void main(String[] args) {
		int arrival[] = { 900, 940, 950, 1100, 1500, 1800 };
		int departure[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		int count = countPlatforms(arrival, departure);
		System.out.println(count);

	}

}
