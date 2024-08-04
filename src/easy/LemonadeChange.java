package easy;

public class LemonadeChange {

	public static boolean lemonadeChange(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		if (nums.length == 0 && nums[0] != 5) {
			return false;
		}
		int[] array = new int[21];
		for (int i : nums) {
			if (i == 5) {
				array[5] = array[5] + 1;
				continue;
			} else {
				if (i == 10) {
					if (array[5] != 0) {
						array[5] = array[5] - 1;
						array[10] = array[10] + 1;
					} else {
						return false;
					}
				}
				if (i == 20) {
					if (array[10] > 0 && array[5] > 0) {
						array[10] = array[10] - 1;
						array[5] = array[5] - 1;
					} else if (array[5] >= 3) {
						array[5] = array[5] - 3;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {5,5,5,10,20};
		System.out.println(lemonadeChange(nums));

	}

}
