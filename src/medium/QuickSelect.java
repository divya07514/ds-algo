package medium;

public class QuickSelect {

	public static int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		k = n - k;
		return quickSelect(0, n - 1, nums, k);
	}

	private static int quickSelect(int left, int right, int[] nums, int k) {
		int pivot = nums[right];
		int index = left;
		for (int i = left; i < right; i++) {
			if (nums[i] <= pivot) {
				swap(nums, i, index);
				index++;
			}
		}
		swap(nums, index, right);
		if (index > k) {
			return quickSelect(left, index - 1, nums, k);
		} else if (index < k) {
			return quickSelect(index + 1, right, nums, k);
		} else {
			return nums[index];
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 7, 2, 4, 5, 7, 6 };
		int k = 4;

		System.out.println(findKthLargest(nums, k));
	}

}
