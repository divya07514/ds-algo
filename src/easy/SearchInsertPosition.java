package easy;
public class SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 1) {
			if (nums[0] < target) {
				return 1;
			} else {
				return 0;
			}
		}
		if (nums[nums.length - 1] < target) {
			return nums.length;
		}
		if (nums[0] > target) {
			return 0;
		}
		return findIndex(nums, target);
	}

	private static int findIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		int index = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (mid - 1 >= 0 && target < nums[mid] && target > nums[mid - 1]) {
				index = mid;
				break;
			} else if (mid + 1 < nums.length && target > nums[mid] && target < nums[mid + 1]) {
				index = mid + 1;
				break;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 6, 7, 8, 9 };
		int target = 6;
		System.out.println(searchInsert(nums, target));
	}
}
