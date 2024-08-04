package medium;

public class SortColors {

	public void sortColors(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return;
		}

		int one = 0;
		int two = n - 1;
		int current = 0;

		while (current <= two) {
			if (nums[current] == 1) {
				current++;
			} else if (nums[current] == 2) {
				swap(nums, current, two);
				two--;
			} else {
				swap(nums, current, one);
				one++;
				current++;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
