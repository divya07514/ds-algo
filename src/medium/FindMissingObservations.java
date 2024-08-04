package medium;
/**
 * This has so many cases
 * @author divya.thakur
 *
 */
public class FindMissingObservations {

	public int[] missingRolls(int[] rolls, int mean, int n) {

		int nums = rolls.length + n;
		int total = nums * mean;
		int sum = 0;
		for (int i : rolls) {
			sum = sum + i;
		}
		int diff = total - sum;
		if (diff < 0) {// case 1
			return new int[0];
		}
		int ans = diff / n;
		int rem = diff % n;
		if (ans > 6 || ans == 0) { // as per question
			return new int[0];
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = ans;
		}
		if (rem == 0) {
			return result;
		}
		int index = 0;
		while (rem > 0) {// try to spread out remainder evenly across all the other numbers in the array.
			result[index] = result[index] + 1;
			rem = rem - 1;
			if (result[index] > 6) {
				return new int[0];
			}
			index++;
		}
		return result;
	}

}
