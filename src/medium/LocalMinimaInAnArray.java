package medium;

public class LocalMinimaInAnArray {

	public static void main(String[] args) {

		int[] nums = { 9, 6, 24, 14, 5, 7, 11 };
		int[] nums1 = { 23, 8, 15, 2, 3 };
		System.out.println(localMinima(nums));
		System.out.println(localMinima(nums1));

	}

	private static int localMinima(int[] nums) {

		int n = nums.length;
		if (n == 0) {
			return -1;
		}

		if (n == 1) {
			return 0;
		}
		if (nums[0] < nums[1]) {
			return 0;
		}

		if (nums[n - 1] < nums[n - 2]) {
			return n - 1;
		}

		int i = 1;
		int j = n - 2;

		while (i <= j) {
			int mid = (i + j) / 2;

			if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				return mid;
			} else if (nums[mid] > nums[mid - 1]) {
				j = mid - 1;
			} else if (nums[mid] > nums[mid + 1]) {
				i = mid + 1;
			} else {
				i = mid - 1;
			}
		}

		return -1;

	}

}
