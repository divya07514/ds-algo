package easy;

public class PartitionIntoThreeParts {

	public static boolean canThreePartsEqualSum(int[] arr) {

		int sum = 0;
		boolean check = true;

		for (int i : arr) {
			if (i != 0) {
				check = false;
			}
			sum = sum + i;
		}
		if (check && arr.length > 2) {
			return true;
		}
		if (sum % 3 != 0) {
			return false;
		}

		int rem = sum / 3;
		int part = 0;
		sum = 0;
		for (int i : arr) {
			if (i == rem && sum==0) {
				part++;
				sum = 0;
				continue;
			}
			sum = sum + i;
			if (sum == rem) {
				part++;
				sum = 0;
			}
		}
		return part == 3;
	}

	public static void main(String[] args) {
		int[] arr = { 11, 16, -6, -14, 9, 14, -19, 8, 13, -13, 29 };
		System.out.println(canThreePartsEqualSum(arr));

	}

}
