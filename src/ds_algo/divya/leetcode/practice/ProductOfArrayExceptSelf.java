package ds_algo.divya.leetcode.practice;

public class ProductOfArrayExceptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] result = new int[n];
		left[0] = 1;
		right[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			left[i] = nums[i - 1] * left[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < n; i++) {
			result[i] = left[i] * right[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] result = productExceptSelf(nums);
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+ " ");
		}

	}

}
