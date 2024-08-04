package medium;

public class PreviousPermutation {

	public static void main(String[] args) {

		int[] one = { 4, 3, 2, 1 };
		int[] two = { 1, 2, 3, 4 };
		int[] three = { 4, 3, 2, 1, 6, 7, 8, 9 };

		prev_perm(three);
		print(three);
	}

	private static void prev_perm(int[] nums) {

		int n = nums.length;
		if (n == 0) {
			return;
		}

		int i = n - 2;

		while (i >= 0 && nums[i + 1] >= nums[i]) {
			i--;
		}

		if (i >= 0) {
			int j = n - 1;
			while (j > i && nums[j] >= nums[i]) {
				j--;
			}
			swap(i, j, nums);
		}
		reverse(i + 1, nums);

	}

	private static void reverse(int i, int[] nums) {
		int j = nums.length - 1;
		while (i <= j) {
			swap(i, j, nums);
			i++;
			j--;
		}

	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	private static void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

}
