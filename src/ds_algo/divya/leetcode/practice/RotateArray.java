package ds_algo.divya.leetcode.practice;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int n = nums.length;
		int rotate = k % n;
		if (rotate == n) {
			return;
		}
		int index = 0;
		while (n - 1 >= rotate) {
			index++;
			n--;
		}
		System.out.println(index);
		int left = index - 1;
		int right = index;
		reverse(0, left, nums);
		reverse(right, nums.length - 1, nums);
		reverse(0, nums.length - 1, nums);
	}

	public static void reverse(int i, int j, int[] nums) {
		while (i < j) {
			swap(i, j, nums);
			i++;
			j--;
		}
	}

	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums, 3);
		ArrayUtil.printArray(nums);

	}

}
