package easy;

public class MinimumValueToGetPositiveStepByStepSum {

	public static int minStartValue(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int min = 0;
		int sum = 0;

		for (int i : nums) {
			sum = sum + i;
			min = Math.min(sum, min);
		}

		return -min + 1;
	}

	public static void main(String[] args) {
		int[] nums = {-3,2,-3,4,2};
		System.out.println(minStartValue(nums));

	}

}
