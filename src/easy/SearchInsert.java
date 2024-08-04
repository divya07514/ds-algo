package easy;

public class SearchInsert {

	public static int searchInsert(int[] nums, int target) {
		if (target < nums[0]) {
			return 0;
		}
		int n = nums.length;
		if (target > nums[n - 1]) {
			return n;
		}
		int left = 0;
		int right = n;
		int res = 0;
		while (left <= right) {
			int mid = (right + left) / 2;
			if (nums[mid] == target) {
				res = mid;
				break;
			}
			System.out.println(left + ", " + right + ", " + mid);
			if (nums[mid] > target && nums[mid - 1] < target) {
				res = mid;
				break;
			}
			if (nums[mid] < target && nums[mid + 1] > target) {
				res = mid + 1;
				break;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1,3};
		int target = 2;
		System.out.println(searchInsert(nums, target));

	}

}
