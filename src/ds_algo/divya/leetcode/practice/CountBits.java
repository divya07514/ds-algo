package ds_algo.divya.leetcode.practice;

public class CountBits {
	
	public static int[] countBits(int num) {

		if (num == 0)
			return new int[] { 0 };
		if (num == 1)
			return new int[] { 0, 1 };

		// The closest power of 2 that is
		// smaller than the current number
		int lastPowerValue = 1;

		// Array to store results
		// This array will be returned
		int[] numOnes = new int[num + 1];

		// Base cases
		numOnes[0] = 0; // 0 = 0000
		numOnes[1] = 1; // 1 = 0001

		// Now find numOnes[i] for all other values
		// starting from 2
		for (int i = 2; i <= num; ++i) {

			// Check if the value is the power of 2.
			// If it is, there's only one '1'.
			// 4 = 0100 | 8 = 1000

			// Instead of using Math.pow,
			// find the next power value dynamically
			if (i == 2 * lastPowerValue) {

				lastPowerValue *= 2; // update
				numOnes[i] = 1; // only one '1'

				// Otherwise,the number of ones is the sum
				// of numOnes[lastPowerValue] and number of ones
				// that has to be added to lastPowerValue to
				// obtain the current number

				// For example,
				// 5 = 4 + 1 = 0100 + 0001 = 0101
				// 7 = 4 + 3 = 0100 + 0011 = 0111
			} else {
				numOnes[i] = numOnes[lastPowerValue] + numOnes[i - lastPowerValue];
			}
		}

		return numOnes;
	}

	public static void main(String[] args) {
		ArrayUtil.printArray(countBits(6));

	}

}
