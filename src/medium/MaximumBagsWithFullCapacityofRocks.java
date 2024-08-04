package medium;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityofRocks {
	public int maximumBags(int[] cap, int[] rocks, int add) {

		if (cap == null || cap.length == 0) {
			return 0;
		}

		int[] diff = new int[cap.length];

		for (int i = 0; i < cap.length; i++) {
			diff[i] = cap[i] - rocks[i];
		}
		Arrays.sort(diff);

		for (int i = 0; i < diff.length; i++) {
			if (diff[i] == 0) {
				continue;
			} else {
				if (add == 0 || add < diff[i]) {
					break;
				}
				add = add - diff[i];
				diff[i] = 0;
			}
		}

		int count = 0;
		for (int i : diff) {
			if (i == 0) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}
