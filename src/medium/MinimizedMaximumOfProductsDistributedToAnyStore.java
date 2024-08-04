package medium;
/**
 * Products here represent the complete search space.
 * @author divya.thakur
 *
 */

public class MinimizedMaximumOfProductsDistributedToAnyStore {

	public static int minimizedMaximum(int n, int[] nums) {
		if (n == 1 && nums.length == 1) {
			return nums[0];
		}
		int left = 1;
		int right = 0;
		for (int i : nums) {
			right = Math.max(right, i);
		}
		int result = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			boolean ans = check(mid, n, nums);
			if (ans) {
				result = Math.min(mid, result);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	private static boolean check(int mid, int n, int[] nums) {
		int count = 0;
		for (int i : nums) {
			count = count + i / mid;
			if (i % mid != 0) {
				count = count + 1;
			}
		}
		if (count <= n) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int n = 6;
		int[] quantities = {11,6};
		System.out.println(minimizedMaximum(n, quantities));

	}

}
