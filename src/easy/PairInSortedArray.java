package easy;

public class PairInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int sum = 1400;
		System.out.println(sum(arr, sum));

	}

	private static boolean sum(int[] arr, int target) {
		int pivot = 0;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				pivot = i;
				break;
			}
		}

		int left = pivot + 1;
		int right = pivot;

		while (left != right) {
			int sum = arr[left] + arr[right];
			if (sum == target) {
				return true;
			} else if (sum > target) {
				right = (right - 1 + n) % n;
			} else {
				left = (left + 1) % n;
			}
		}

		return false;
	}

}
